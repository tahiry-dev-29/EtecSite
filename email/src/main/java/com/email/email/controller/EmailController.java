package com.email.email.controller;

import com.email.email.dto.EmailRequest;
import com.email.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {


    private final EmailService service;


    @PostMapping("/send")
    public ResponseEntity<?> send(
            @RequestBody EmailRequest request
    )throws Exception{


        service.sendEmail(request);


        return ResponseEntity.ok(
                "Email envoyé"
        );

    }

}
