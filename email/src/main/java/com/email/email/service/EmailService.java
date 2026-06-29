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


        // email de l'expéditeur
        helper.setFrom("flavienrandria81@gmail.com");


        // destinataire
        helper.setTo(
                request.getTo()
        );


        // sujet
        helper.setSubject(
                request.getSubject()
        );


        // contenu du mail
        helper.setText(
                request.getMessage(),
                true
        );


        // pièce jointe si existe
        if(request.getAttachment() != null
                && request.getFileName() != null) {


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