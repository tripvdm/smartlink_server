package com.example.smartlink.repository;

import com.example.smartlink.dto.SmartLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SmartLinkRepository extends JpaRepository<SmartLink, Long> {
    List<SmartLink> findByUserSlId(UUID id);
}
