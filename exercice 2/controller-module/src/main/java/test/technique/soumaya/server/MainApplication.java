package test.technique.soumaya.server;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("test.technique.soumaya")
@EnableJpaRepositories("test.technique.soumaya.core.repositories")
@EntityScan("test.technique.soumaya.core.entities")
@EnableWebMvc
public class MainApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		logger.info("---  MainApplication Server is running ------");
	}

}