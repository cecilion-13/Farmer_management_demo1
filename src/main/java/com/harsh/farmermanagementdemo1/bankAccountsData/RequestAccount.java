package com.harsh.farmermanagementdemo1.bankAccountsData;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RequestAccount {

    private String accountNumber;
    private String ifscCode;
    private BigDecimal currentBalance;
    private String email;

}
