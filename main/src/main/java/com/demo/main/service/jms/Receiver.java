package com.demo.main.service.jms;

import com.demo.main.type.dto.EmailDto;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private final JavaMailSender javaMailSender;

    public Receiver(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(EmailDto email) {
        sendMail(email.getTo(), email.getSubject(), email.getBody());
    }

    private void sendMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }

}
