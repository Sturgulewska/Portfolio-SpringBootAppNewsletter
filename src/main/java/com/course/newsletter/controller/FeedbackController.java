package com.course.newsletter.controller;

import com.course.newsletter.configuration.EmailConfiguration;
import com.course.newsletter.data.dto.Feedback;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final EmailConfiguration emailConfiguration;

    public FeedbackController(EmailConfiguration emailConfiguration) {
        this.emailConfiguration = emailConfiguration;
    }

    @PostMapping
    public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback nie jest ważny");}

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();


    }
}
