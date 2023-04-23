package com.example.smartlink.service;

import com.example.smartlink.dto.SmartLink;
import com.example.smartlink.repository.SmartLinkRepository;
import com.example.smartlink.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtoService {
    @Autowired
    private SmartLinkRepository smartLinkRepository;

    @Autowired
    private UserRepository userRepository;

    public List<SmartLink> findSmartLinkList() {
        return smartLinkRepository.findAll();
    }

    public void deleteSmartLink(SmartLink smartLink) {
        smartLinkRepository.delete(smartLink);
    }
}
