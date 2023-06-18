package com.example.tarlascraping1.EmailProcess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailToken, Integer> {
    EmailToken findByToken(String token);
}
