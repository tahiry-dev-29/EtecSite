package com.admin.admin.service;

import com.admin.admin.client.UserFeignClient;
import com.admin.admin.dto.AdminDto;
import com.admin.admin.dto.UserResponseDTO;
import com.admin.admin.entity.Admin;
import com.admin.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final UserFeignClient userFeignClient;

    public AdminDto getAdmin(Long userId) {

        Admin admin = adminRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profil Admin local introuvable"));

        UserResponseDTO authInfo = userFeignClient.getUserById(userId).getBody();

        AdminDto adminDto = new AdminDto();
        adminDto.setUserId(userId);

        if (authInfo != null) {
            adminDto.setUsername(authInfo.getUsername());
            adminDto.setEmail(authInfo.getEmail());
            adminDto.setRole(authInfo.getRole());
        }

        adminDto.setNom(admin.getFirstName());
        adminDto.setPrenom(admin.getLastName());
        adminDto.setDepartement(admin.getPhoneNumber());

        return adminDto;
    }

    public void deleteAdmin(Long userId) {
        userFeignClient.deleteUser(userId);
        adminRepository.findByUserId(userId)
                .ifPresent(adminRepository::delete);
    }
}