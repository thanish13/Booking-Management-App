package org.t13.app;

import io.opentelemetry.instrumentation.spring.autoconfigure.internal.instrumentation.webmvc.SpringWebMvc6InstrumentationAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaRepositories
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class,
		DataSourceAutoConfiguration.class,
		org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.class,
		SpringWebMvc6InstrumentationAutoConfiguration.class})
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

}
