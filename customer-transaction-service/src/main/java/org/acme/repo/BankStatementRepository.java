package org.acme.repo;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.bank.BankStatement;


@ApplicationScoped
public class BankStatementRepository implements PanacheRepository<BankStatement> {
}
