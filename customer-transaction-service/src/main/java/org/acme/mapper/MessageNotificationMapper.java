package org.acme.mapper;

import org.acme.dto.HeaderDTO;
import org.acme.dto.MessageResponseDTO;
import org.acme.dto.NotificationResponseDTO;
import org.acme.model.HeaderInfo;
import org.acme.model.MessageNotification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "cdi")
public interface MessageNotificationMapper {
    @Mapping(source = "notificationResponse.id", target = "id")
    @Mapping(source = "messageResponse.header", target = "messageInfo.headerInfo", qualifiedByName = "mapHeader")
    @Mapping(source = "messageResponse.id", target = "messageInfo.messageId")
    @Mapping(source = "notificationResponse.notificationStatus", target = "notificationStatus")
    @Mapping(source = "notificationResponse.notificationType", target = "notificationType")
    @Mapping(expression = "java(combineStatus(messageResponse.getStatus(), notificationResponse.getNotificationStatus()))", target = "combinedStatus")
    MessageNotification toEntity(MessageResponseDTO messageResponse, NotificationResponseDTO notificationResponse);

    @Named("combineStatus")
    default String combineStatus(String messageStatus, String notificationStatus) {
        return messageStatus + "-" + notificationStatus;
    }
    @Named("mapHeader")
    @Mapping(source = "sourceSystem", target = "sourceSystem")
    @Mapping(source = "sourceBank", target = "sourceBank")
    HeaderInfo toEntity(HeaderDTO headerDTO);
}
