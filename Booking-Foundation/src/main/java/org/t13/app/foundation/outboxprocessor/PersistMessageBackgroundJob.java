package org.t13.app.foundation.outboxprocessor;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.ScheduledFuture;

@Configuration
@Import({PersistMessageProcessorConfiguration.class})
public class PersistMessageBackgroundJob {

    private final TaskScheduler taskScheduler;
    private final PersistMessageProcessor persistMessageProcessor;
    private final Logger logger;
    private final TransactionTemplate transactionTemplate;
    private ScheduledFuture<?> scheduledTask;

    public PersistMessageBackgroundJob(
            TaskScheduler taskScheduler,
            PersistMessageProcessor persistMessageProcessor,
            Logger logger,
            @Qualifier("transactionManager") JpaTransactionManager transactionManager) {
        this.taskScheduler = taskScheduler;
        this.persistMessageProcessor = persistMessageProcessor;
        this.logger = logger;
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @PostConstruct
    public void startBackgroundJob() {
        scheduledTask = taskScheduler.scheduleAtFixedRate(() -> {
            try {
                transactionTemplate.execute(status -> {
                    persistMessageProcessor.processAll();
                    return null;
                });
            } catch (Exception ex) {
                logger.error("Error in persistent message processing", ex);
            }
        }, 60000);
    }

    @PreDestroy
    public void stopBackgroundJob() {
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
        }
    }
}
