package com.rushen.SpringSecurity.Repo;

import com.rushen.SpringSecurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    //what is the use of this
    //this is used to find the user by email
    //but why is it in the repository class
    //because we are using the jpa repository to find the user by email
}
