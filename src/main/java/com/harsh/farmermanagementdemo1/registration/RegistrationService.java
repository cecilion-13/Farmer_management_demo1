package com.harsh.farmermanagementdemo1.registration;

import com.harsh.farmermanagementdemo1.appuser.AppUser;
import com.harsh.farmermanagementdemo1.appuser.AppUserRole;
import com.harsh.farmermanagementdemo1.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {
        return appUserService.signUpUser(
                new AppUser(
                        request.getName(),
                        request.getContactNumber(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getAddress(),
                        AppUserRole.FARMER
                )
        );
    }

}
