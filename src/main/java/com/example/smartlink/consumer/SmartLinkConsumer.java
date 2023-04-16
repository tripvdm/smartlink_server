package com.example.smartlink.consumer;

import com.example.smartlink.dto.SmartLinkDTO;
import com.example.smartlink.repository.SmartLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/** TODO connect to hibernate and execute requests to DB**/
@Component
public class SmartLinkConsumer {
    @Autowired
    private SmartLinkRepository smartLinkRepository;

    @KafkaListener(topics = "smartLink", groupId = "kafka-snadbox")
    public void listener(SmartLinkDTO smartLinkDTO) {
        smartLinkRepository.save(smartLinkDTO);
    }

    public List<SmartLinkDTO> findSmartLInkListByUserId(Long userId) {
        return smartLinkRepository.findAll();
    }

    /**TODO delete smart link**/
    public void deleteSmartLink(Long userId, Long smartLinkId) {

    }

    /**TODO update smart link**/
    public void updateSmartLink(SmartLinkDTO smartLinkDTO, Long userId, Long smartLinkId) {

    }
}
