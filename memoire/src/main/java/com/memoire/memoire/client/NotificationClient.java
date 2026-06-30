package com.memoire.memoire.client;

import com.common.common.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATION")
public interface NotificationClient {

    @PostMapping("/notifications/send")
    void envoyer(@RequestBody NotificationRequest request);
}
