package com.harsh.farmermanagementdemo1.appuser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Document(collection="registrations")
public class AppUser implements UserDetails {

    @Id
    private String id;

    private String name;

    private String contactNumber;

    private String email;

    private String password;

    private String address;

    private AppUserRole appUserRole;
    private Boolean locked = false;
    private Boolean enabled = true;

    public AppUser(String name,
                   String contactNumber,
                   String email,
                   String password,
                   String address,
                   AppUserRole appUserRole) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.password = password;
        this.address = address;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
