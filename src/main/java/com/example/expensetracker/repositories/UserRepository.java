package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *  Naming conventions for a repository are findBy[PropertyName]
 *  find by multiple things findByThing1AndThing2
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByVerificationCode(String verificationCode);
}
