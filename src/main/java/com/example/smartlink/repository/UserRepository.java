package com.example.smartlink.repository;

import com.example.smartlink.dto.UserSl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserSl, Long> {
    UserSl findByEmail(String email);
}
