package com.example.smartlink.controller;

import com.example.smartlink.consumer.SmartLinkConsumer;
import com.example.smartlink.dto.SmartLinkDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/smartLinkListApi")
@RequiredArgsConstructor
public class ApiRestController {
    @Autowired
    private KafkaTemplate<String, SmartLinkDTO> kafkaTemplate;
    private SmartLinkConsumer smartLinkConsumer;

    @PostMapping("/add")
    public void addSmartLink(@RequestBody SmartLinkDTO smartLinkDTO) {
        kafkaTemplate.send("smartLink", smartLinkDTO);
    }

    @GetMapping("/smartLinkListApi/{userId}")
    public List<SmartLinkDTO> getSmartLinkList(@PathVariable Long userId) {
        return smartLinkConsumer.findSmartLInkListByUserId(userId);
    }

    @DeleteMapping("/smartLinkListApi/{userId}/{smartLinkId}")
    public void deleteSmartLink(@PathVariable Long userId, @PathVariable Long smartLinkId) {
        smartLinkConsumer.deleteSmartLink(userId, smartLinkId);
    }

    @PutMapping("/smartLinkListApi/{userId}/{smartLinkId}")
    public void updateSmartLinkList(@RequestBody SmartLinkDTO smartLinkDTO,
                                     @PathVariable Long userId, @PathVariable Long smartLinkId) {
        smartLinkConsumer.updateSmartLink(smartLinkDTO, userId, smartLinkId);
    }
}
