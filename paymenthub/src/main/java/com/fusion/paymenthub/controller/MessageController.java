package com.fusion.paymenthub.controller;

import com.fusion.paymenthub.dto.MessageRequest;
import com.fusion.paymenthub.dto.MessageResponse;
import com.fusion.paymenthub.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @PostMapping("/CreateMessage")
    public ResponseEntity <MessageResponse> createMessage(@RequestBody MessageRequest messageRequest){
        return new ResponseEntity<>(messageService.createMessage(messageRequest), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getMessageById(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.getMessageById(id));
    }
}
