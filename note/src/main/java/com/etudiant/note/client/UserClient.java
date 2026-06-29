package com.etudiant.note.client;

import com.etudiant.note.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="UTILISATEUR")
public interface UserClient {

    @GetMapping("/api/auth/users/{id}")
    UserDto getUser(@PathVariable Long id);
}
