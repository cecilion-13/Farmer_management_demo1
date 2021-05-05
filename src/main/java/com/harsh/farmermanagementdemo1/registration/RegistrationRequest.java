package com.harsh.farmermanagementdemo1.registration;

import com.harsh.farmermanagementdemo1.validation.ValidPassword;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private final String name;

    @NotEmpty
    @NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12)
    private final String contactNumber;

    @NotNull
    @NotEmpty
    @Email
    private final String email;

    @NotEmpty
    @ValidPassword
    private final String password;

    @NotNull
    @Size(min = 5, max = 50)
    private String address;
}
