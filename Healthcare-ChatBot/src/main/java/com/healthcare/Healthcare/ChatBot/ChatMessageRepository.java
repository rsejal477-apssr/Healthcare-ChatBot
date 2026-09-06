package com.healthcare.Healthcare.ChatBot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findByUserEmailOrderByTimestampAsc(String userEmail);
}