package com.example.regLoginDemo.appUser;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface userRepository extends MongoRepository<AppUser,Long> {
    Optional<AppUser> findByEmail(String email);
}
