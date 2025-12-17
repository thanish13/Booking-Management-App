package org.t13.app.foundation.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaAuditing
public class JpaConfiguration {

    @Value("${spring.jpa.entity-packages-to-scan}")
    private String entityPackagesToScan;

    @Bean("dataSourceProps")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    };

    @Bean("dataSource")
    @Profile("!test")
    public DataSource dataSource(@Qualifier("dataSourceProps") DataSourceProperties dataSourceProperties) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println("Password" + dataSourceProperties.getPassword());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        return dataSource;
    }

    @Bean("entityManagerFactory")
    @Profile("!test")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("dataSource") DataSource dataSource,
            JpaProperties jpaProperties,
            HibernateProperties hibernateProperties) {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        // Set the datasource
        factoryBean.setDataSource(dataSource);

        // Set packages to scan from configuration
        factoryBean.setPackagesToScan(entityPackagesToScan, "org.t13.app.foundation");

        // Set JPA vendor adapter
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);

        // Merge JPA and Hibernate properties
        Properties properties = new Properties();
        properties.putAll(hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings()));
        properties.putAll(jpaProperties.getProperties());

        factoryBean.setJpaProperties(properties);

        return factoryBean;
    }

    @Primary
    @Bean("transactionManager")
    @Profile("!test")
    public JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Primary
    @Bean("entityManager")
    @Profile("!test")
    public EntityManager entityManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory){
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    @Profile("!test")
    public AuditorAware<Long> auditorAware() {
        return new JpaAuditorAwareImpl();
    }
}