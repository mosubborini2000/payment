package com.fusion.paymenthub.service;

import com.fusion.paymenthub.dto.MessageRequest;
import com.fusion.paymenthub.dto.MessageResponse;

public interface MessageService {

    MessageResponse createMessage(MessageRequest messageRequest);

    MessageResponse getMessageById(Long id);
}
