package com.fusion.paymenthub.service;

import com.fusion.paymenthub.dto.MessageRequest;
import com.fusion.paymenthub.dto.MessageResponse;
import com.fusion.paymenthub.mapper.MessageMapper;
import com.fusion.paymenthub.model.Message;
import com.fusion.paymenthub.repository.MessageRepositry;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService {
    private final MessageRepositry messageRepository;
    private final MessageMapper messageMapper;


    public MessageServiceImp( MessageRepositry messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }
    @Override
    public MessageResponse createMessage(MessageRequest messageRequest) {
        Message message = messageMapper.toEntity(messageRequest);
        messageRepository.save(message);
        return messageMapper.toResponseDTO(message);
    }

    @Override
    public MessageResponse getMessageById(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        return messageMapper.toResponseDTO(message);
    }
}
