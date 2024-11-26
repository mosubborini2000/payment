package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Notification;


@ApplicationScoped
public class NotificationRepository implements PanacheRepository<Notification> {
}
