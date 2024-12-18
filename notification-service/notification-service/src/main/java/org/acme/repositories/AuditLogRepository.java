package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Audit;

@ApplicationScoped
public class AuditLogRepository implements PanacheRepository<Audit> {
}
