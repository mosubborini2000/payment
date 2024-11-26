package org.acme.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.NotificationRequest;
import org.acme.dto.NotificationResponse;
import org.acme.service.NotificationService;

@Path("/notifications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationResource {

    private final NotificationService notificationService;

    public NotificationResource(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @POST
    public Response createNotification(NotificationRequest request) {
        NotificationResponse response = notificationService.createNotification(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
