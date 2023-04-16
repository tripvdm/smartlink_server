package com.example.smartlink.repository;

import com.example.smartlink.dto.SmartLinkDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartLinkRepository extends JpaRepository<SmartLinkDTO, Long> {
}
