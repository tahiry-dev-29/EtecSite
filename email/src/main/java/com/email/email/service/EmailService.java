package com.email.email.service;


import com.email.email.dto.EmailRequest;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailService {


    private final JavaMailSender mailSender;


    public void sendEmail(EmailRequest request) throws Exception {


        MimeMessage message =
                mailSender.createMimeMessage();


        MimeMessageHelper helper =
                new MimeMessageHelper(
                        message,
                        true
                );


        helper.setTo(request.getTo());

        helper.setSubject(
                request.getSubject()
        );


        helper.setText(
                request.getMessage()
        );


        if(request.getAttachment()!=null){

            helper.addAttachment(
                    request.getFileName(),
                    new ByteArrayResource(
                            request.getAttachment()
                    )
            );

        }


        mailSender.send(message);
    }
}