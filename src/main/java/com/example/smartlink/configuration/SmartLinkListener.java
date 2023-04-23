package com.example.smartlink.configuration;

import com.example.smartlink.dto.SmartLink;
import com.example.smartlink.dto.UserSl;
import com.example.smartlink.repository.SmartLinkRepository;
import com.example.smartlink.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartLinkListener {
    @Autowired
    private SmartLinkRepository smartLinkRepository;

    @Autowired
    private UserRepository userRepository;

    @RabbitListener(queues = {RabbitConfiguration.QUEUE_SMARTLINK})
    public void onSmartLink(SmartLink smartLink) {
        smartLinkRepository.save(smartLink);
    }

    @RabbitListener(queues = {RabbitConfiguration.QUEUE_USER})
    public void onSmartLink(UserSl userSl) {
        userRepository.save(userSl);
    }
}
