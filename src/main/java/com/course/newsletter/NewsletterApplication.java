package com.course.newsletter;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NewsletterApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new SpringApplicationBuilder(NewsletterApplication.class)
				.headless(false)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}

}
