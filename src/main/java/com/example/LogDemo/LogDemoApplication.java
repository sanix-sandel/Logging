package com.example.LogDemo;

import com.example.LogDemo.repositories.PostDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogDemoApplication {


	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(PostDB.class);

		logger.info("Starting The Demo log application");
		logger.warn("No caching mechanism implemented");
		SpringApplication.run(LogDemoApplication.class, args);
	}

}
