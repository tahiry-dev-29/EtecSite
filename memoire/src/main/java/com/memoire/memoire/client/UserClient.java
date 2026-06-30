package com.memoire.memoire.client;

import com.memoire.memoire.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UTILISATEUR")
public interface UserClient {
    @GetMapping("/api/auth/users/{id}")
    UserDto findById(@PathVariable Long id);
}
