package ru.app.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "ru.app")
@EnableZuulProxy
public class ProxyClientAppWebApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(ProxyClientAppWebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProxyClientAppWebApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("Server is ready to work.");
	}

	@Bean
	public SessionSetZuulPreFilter sessionSetZuulPreFilter() {
		return new SessionSetZuulPreFilter();
	}

}
