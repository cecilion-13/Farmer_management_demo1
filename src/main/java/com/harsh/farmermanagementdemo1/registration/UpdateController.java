package com.harsh.farmermanagementdemo1.registration;

import com.harsh.farmermanagementdemo1.authenticate.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/farmers")
@AllArgsConstructor
public class UpdateController {
    private final UpdateService updateService;

    private final JwtUtil jwtUtil;

    @PutMapping("/update_profile")
    public String register(@RequestHeader("Authorization") String token,
                           @Valid @RequestBody RegistrationRequest request){
        String userEmail = null;
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            userEmail = jwtUtil.extractUsername(jwtToken);
        }
        if(userEmail!=null)
        return updateService.update(request,userEmail);
        else{
             return "User Not found";
        }
    }

}
