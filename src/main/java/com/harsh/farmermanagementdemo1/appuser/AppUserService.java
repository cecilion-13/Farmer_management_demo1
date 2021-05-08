package com.harsh.farmermanagementdemo1.appuser;

import com.harsh.farmermanagementdemo1.exception.EmailAlreadyTakenException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if (userExists) {
            throw new EmailAlreadyTakenException(appUser.getEmail());
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);
        return "Registration Successful";
    }

    public String updateUser(AppUser appUser,String email) {
        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUserRepository.findByEmail(email)
                .map(appUser1 -> {
                    appUser1.setName(appUser.getName());
                    appUser1.setContactNumber(appUser.getContactNumber());
                    appUser1.setEmail(appUser.getEmail());
                    appUser1.setPassword(encodedPassword);
                    appUser1.setAppUserRole(appUser.getAppUserRole());
                    return appUserRepository.save(appUser1);
                })
                .orElseGet(() -> {
                    appUser.setEmail(email);
                    return appUserRepository.save(appUser); });
        return "Updation Successful";
    }

    public Optional<AppUser> viewUser(String email){
        return appUserRepository.findByEmail(email);
    }
}
