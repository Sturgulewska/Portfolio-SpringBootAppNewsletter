package com.course.newsletter.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class EmailConfiguration {
    @Value("${mail.dev.host}")
    private String host;

    @Value("${mail.dev.port}")
    private int port;

    @Value("${mail.dev.login}")
    private String username;

    @Value("${mail.dev.password}")
    private String password;

    @Value("${mail.dev.sender}")
    private String emailSender;
}
