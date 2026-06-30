package com.moyenne.client;

import com.moyenne.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UTILISATEUR")
public interface UserClient {

    @GetMapping("/api/auth/users/{id}")
    UserDto user(@PathVariable Long id);
}
