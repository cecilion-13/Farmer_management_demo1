package com.harsh.farmermanagementdemo1.appuser;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends MongoRepository<AppUser,String> {
    Optional<AppUser> findByEmail(String email);

}