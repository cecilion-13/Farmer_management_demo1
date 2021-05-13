package com.harsh.farmermanagementdemo1.bankAccountsData;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private ObjectId _id;
    private String accountNumber;
    private String ifscCode;
    private BigDecimal currentBalance;
    private String email;

    public Account(String accountNumber, String ifscCode, BigDecimal currentBalance, String email) {
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.currentBalance = currentBalance;
        this.email = email;
    }

    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

}
