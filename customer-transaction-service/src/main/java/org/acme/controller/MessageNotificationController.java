package org.acme.controller;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.NotificationRequestDTO;
import org.acme.model.MessageNotification;
import org.acme.service.MessageNotificationService;

@Path("/message-notifications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageNotificationController {

    private final MessageNotificationService service;

    public MessageNotificationController(MessageNotificationService service) {
        this.service = service;
    }

    @POST
    @Path("/{messageId}")
    public Response createMessageNotification(@PathParam("messageId") Long messageId, NotificationRequestDTO request) {
        MessageNotification result = service.processMessageNotification(messageId, request);
        return Response.status(Response.Status.CREATED).entity(result).build();
    }
}
