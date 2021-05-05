package com.harsh.farmermanagementdemo1.registration;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@Valid @RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

}
