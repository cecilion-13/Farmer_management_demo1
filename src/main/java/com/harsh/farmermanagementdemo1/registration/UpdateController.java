package com.harsh.farmermanagementdemo1.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="api/v1/registration/update")
@AllArgsConstructor
public class UpdateController {
    private final UpdateService updateService;

    @PutMapping("{email}")
    public String register(@Valid @RequestBody RegistrationRequest request,@PathVariable String email){
        return updateService.update(request,email);
    }



}
