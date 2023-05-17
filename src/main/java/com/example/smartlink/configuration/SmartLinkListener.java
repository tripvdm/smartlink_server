package com.example.smartlink.configuration;

import com.example.smartlink.dto.SmartLink;
import com.example.smartlink.dto.UserSl;
import com.example.smartlink.repository.SmartLinkRepository;
import com.example.smartlink.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SmartLinkListener {
    @Autowired
    private SmartLinkRepository smartLinkRepository;

    @Autowired
    private UserRepository userRepository;

    @RabbitListener(queues = {RabbitConfiguration.QUEUE_SMARTLINK})
    @Transactional
    public void onSmartLinkListener(SmartLink smartLink) {
        UserSl userSl = smartLink.getUserSl();
        userSl = userRepository.findByEmail(userSl.getEmail());
        smartLink.setUserSl(userSl);
        smartLinkRepository.save(smartLink);
    }

    @RabbitListener(queues = {RabbitConfiguration.QUEUE_USER})
    @Transactional
    public void onSmartLinkListener(UserSl userSl) {
        UserSl sameUserSl = userRepository.findByEmail(userSl.getEmail());
        if (sameUserSl == null) {
            userRepository.save(userSl);
        }
    }
}
