package com.harsh.farmermanagementdemo1.registration;

import com.harsh.farmermanagementdemo1.appuser.AppUser;
import com.harsh.farmermanagementdemo1.appuser.AppUserRole;
import com.harsh.farmermanagementdemo1.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateService {
    private final AppUserService appUserService;

    public String update(RegistrationRequest request,String email){
        return appUserService.updateUser(
                new AppUser(
                        request.getName(),
                        request.getContactNumber(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getAddress(),
                        AppUserRole.FARMER
                ),
                email
        );
    }
}
