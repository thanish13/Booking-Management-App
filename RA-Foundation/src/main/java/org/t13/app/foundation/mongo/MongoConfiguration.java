package org.t13.app.foundation.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfiguration {

    @Bean("mongoProps")
    @Primary
    public MongoProperties mongoProperties(){
        return new MongoProperties();
    };
    
    @Bean
    public MongoClient mongoClient(@Qualifier("mongoProps") MongoProperties mongoProperties) {
        return MongoClients.create(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoProperties.getUri()))
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build());
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient, @Qualifier("mongoProps") MongoProperties mongoProperties) {
        return new MongoTemplate(mongoClient, mongoProperties.getDatabase());
    }
}
