package com.harsh.farmermanagementdemo1.viewProfile;

import com.harsh.farmermanagementdemo1.appuser.AppUser;
import com.harsh.farmermanagementdemo1.appuser.AppUserService;
import com.harsh.farmermanagementdemo1.authenticate.JwtUtil;
import com.harsh.farmermanagementdemo1.registration.RegistrationRequest;
import com.harsh.farmermanagementdemo1.registration.RegistrationService;
import com.harsh.farmermanagementdemo1.tryNew.FarmerDetails;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProfileViewController {
    private final AppUserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/farmers/view_profile")
    public UserDetails viewProfile(@RequestHeader("Authorization") String token){
        String userEmail = null;
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            userEmail = jwtUtil.extractUsername(jwtToken);
        }
            return userService.loadUserByUsername(userEmail);
    }

    @GetMapping("/details/{email}")
    public FarmerDetails demo1(@PathVariable("email") String email){
            return userService.viewFarmer(email);
    }


}
