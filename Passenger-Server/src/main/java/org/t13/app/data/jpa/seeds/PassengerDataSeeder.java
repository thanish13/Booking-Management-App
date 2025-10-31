package org.t13.app.data.jpa.seeds;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.t13.app.data.mongo.documents.PassengerDocument;

import static org.t13.app.passengers.features.Mappings.toPassengerDocument;


@Component
public class PassengerDataSeeder implements CommandLineRunner {

    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final MongoTemplate mongoTemplate;
    private final Logger logger;

    public PassengerDataSeeder(
            EntityManager entityManager,
            PlatformTransactionManager platformTransactionManager,
            MongoTemplate mongoTemplate,
            Logger logger) {
        this.entityManager = entityManager;
        this.transactionTemplate = new TransactionTemplate(platformTransactionManager);

        this.mongoTemplate = mongoTemplate;
        this.logger = logger;
    }

    @Override
    public void run(String... args) throws Exception {
        transactionTemplate.execute(status -> {
            try {
                logger.info("Passenger data seeder is started.");

                seedPassenger();

                logger.info("Passenger data seeder is finished.");

                return null;
            }catch (Exception ex) {
                status.setRollbackOnly();
                logger.error(ex.getMessage(), ex);
                throw ex;
            }
        });
    }

    private void seedPassenger() {
        if ((Long) entityManager.createQuery("SELECT COUNT(a) FROM PassengerEntity a").getSingleResult() == 0) {
            InitialPassengerData.passengers.forEach(entityManager::persist);

            if (mongoTemplate.getCollection("passengers").countDocuments() == 0) {
                InitialPassengerData.passengers.forEach(passenger -> {
                    PassengerDocument passengerDocument = toPassengerDocument(passenger);
                    mongoTemplate.insert(passengerDocument);
                });
            }
        }
    }
}



