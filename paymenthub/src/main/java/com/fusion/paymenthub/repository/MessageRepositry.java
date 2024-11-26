package com.fusion.paymenthub.repository;

import com.fusion.paymenthub.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepositry extends JpaRepository<Message,Long> {


}
