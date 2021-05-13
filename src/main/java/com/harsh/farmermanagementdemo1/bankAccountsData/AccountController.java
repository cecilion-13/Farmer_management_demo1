package com.harsh.farmermanagementdemo1.bankAccountsData;

import com.harsh.farmermanagementdemo1.authenticate.JwtUtil;
import com.harsh.farmermanagementdemo1.cropsData.RequestItem;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bank")
public class AccountController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/add_account")
    public Account addAccount(@RequestHeader("Authorization") String token,
                              @RequestBody RequestAccount account){
        String userEmail = null;
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            userEmail = jwtUtil.extractUsername(jwtToken);
        }
        account.setEmail(userEmail);
        Account addedAccount = restTemplate.postForObject(
                "http://account-info-service/api/account/create",
                account,
                Account.class);
        return addedAccount;
    }

    @GetMapping("/statement/{acc_no}")
    public AccountStatement getStatement(@PathVariable("acc_no") String acc_no){
      AccountStatement statement = restTemplate.getForObject(
              "http://account-info-service/api/account/statement/"+acc_no,
              AccountStatement.class
      );
      return statement;
    }


}
