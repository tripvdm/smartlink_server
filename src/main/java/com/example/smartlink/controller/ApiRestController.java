package com.example.smartlink.controller;

import com.example.smartlink.configuration.RabbitConfiguration;
import com.example.smartlink.dto.SmartLink;
import com.example.smartlink.dto.UserSl;
import com.example.smartlink.service.DtoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api")
public class ApiRestController {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private DtoService dtoService;

    public ApiRestController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/addLink")
    public ResponseEntity<String> addSmartLink(@RequestBody SmartLink smartLink) {
        rabbitTemplate.convertAndSend("", RabbitConfiguration.QUEUE_SMARTLINK, smartLink);
        return ResponseEntity.ok("Smart link sent to the consumer");
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUSer(@RequestBody UserSl user) {
        rabbitTemplate.convertAndSend("", RabbitConfiguration.QUEUE_USER, user);
        return ResponseEntity.ok("Smart link sent to the consumer");
    }

    @GetMapping
    public List<SmartLink> getSmartLinkList() {
        return dtoService.findSmartLinkList();
    }

    @DeleteMapping
    public void deleteSmartLink(SmartLink smartLink) {
        dtoService.deleteSmartLink(smartLink);
    }

    @PutMapping
    public ResponseEntity<String> updateSmartLinkList(@RequestBody SmartLink smartLink) {
        rabbitTemplate.convertAndSend("", RabbitConfiguration.QUEUE_SMARTLINK, smartLink);
        return ResponseEntity.ok("Smart link sent to the consumer");
    }
}
