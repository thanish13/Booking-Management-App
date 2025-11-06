package org.t13.app.foundation.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@Import(Flyway.class)
public class FlywayConfiguration {

    @Bean
    public org.flywaydb.core.api.configuration.Configuration configuration(){
        return new ClassicConfiguration();
    }

    @Bean("flywayProps")
    @Primary
    public FlywayProperties flywayProperties() {
        FlywayProperties properties = new FlywayProperties();
        // Customize properties here
        properties.setLocations(List.of(new String[]{"classpath:db/migration"}));
        properties.setBaselineOnMigrate(true);
        // ... set other Flyway properties as needed
        return properties;
    }


    @Bean
    public Flyway flyway(@Qualifier("dataSource") DataSource dataSource, @Qualifier("flywayProps") FlywayProperties flywayProperties) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations(flywayProperties.getLocations().toArray(new String[0])) // Adjust as needed
                .load();
    }

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy(Logger logger, @Qualifier("flywayProps") FlywayProperties flywayProperties) {
        return flyway -> {
            if (!flywayProperties.isEnabled()) {
                logger.info("Flyway migrations are disabled.");
                return;
            }

            Flyway configuredFlyway = Flyway.configure()
                    .dataSource(flyway.getConfiguration().getDataSource())
                    .locations(flywayProperties.getLocations().toArray(new String[0]))
                    .baselineOnMigrate(flywayProperties.isBaselineOnMigrate())
                    .baselineVersion(flywayProperties.getBaselineVersion())
                    .validateOnMigrate(flywayProperties.isValidateOnMigrate())
                    .cleanDisabled(flywayProperties.isCleanDisabled())
                    .load();

            logger.info("Starting Flyway migration...");
            try {
                configuredFlyway.migrate();
                logger.info("Flyway migration completed successfully!");
            } catch (Exception ex) {
                logger.error("Flyway migration failed: {}", ex.getMessage(), ex);
                throw ex;
            }
        };
    }
}
