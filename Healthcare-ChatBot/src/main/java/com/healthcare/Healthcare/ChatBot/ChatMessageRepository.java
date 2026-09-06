package com.healthcare.Healthcare.ChatBot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findByUserEmailOrderByTimestampAsc(String userEmail);

    @Transactional
    void deleteByUserEmail(String userEmail);
}