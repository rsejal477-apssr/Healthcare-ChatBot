package com.healthcare.Healthcare.ChatBot;

import com.google.genai.Client;
import java.util.List;
import java.time.LocalDateTime;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatBotController {

    private final Client client;
    private final ChatMessageRepository chatMessageRepository;

    public ChatBotController(ChatMessageRepository chatMessageRepository) {
        client = new Client();
        this.chatMessageRepository = chatMessageRepository;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request, HttpSession session) {

        String message = request.getMessage();

        if (message == null || message.trim().isEmpty()) {
            return "Please enter a health question.";
        }

        String lowerMessage = message.toLowerCase();

        // Emergency symptom detection
        String[] emergencyKeywords = {
                "chest pain",
                "difficulty breathing",
                "can't breathe",
                "cannot breathe",
                "severe bleeding",
                "unconscious",
                "seizure",
                "stroke",
                "suicide",
                "severe allergic reaction"
        };

        for (String keyword : emergencyKeywords) {

            if (lowerMessage.contains(keyword)) {

                return """
                        🚨 EMERGENCY WARNING

                        Your message may describe a medical emergency.

                        Please contact your local emergency medical service
                        or seek immediate medical attention.

                        Do not rely on this chatbot for emergency care.
                        """;
            }
        }

        // Normal healthcare questions
        String prompt = """
                You are a helpful and safe healthcare information chatbot.

                Your job is to provide general health information in simple,
                easy-to-understand language.

                Follow these rules:

                1. Do not diagnose the user or claim that they definitely have
                   a particular disease.

                2. Do not prescribe medicines or provide medication dosages.

                3. Give practical general health advice such as hydration,
                   rest, healthy food, sleep, exercise, and when to seek
                   professional medical care.

                4. If the user describes serious symptoms, advise them to
                   seek professional medical attention.

                5. If the question is unclear, ask a simple follow-up question.

                6. Keep responses concise and easy to read.

                7. When appropriate, structure the answer using:
                   - Possible reasons
                   - What you can do
                   - When to see a doctor

                8. Always remind the user that the chatbot provides general
                   health information and is not a substitute for a qualified
                   healthcare professional.

                User's question:
                """ + message;

        GenerateContentConfig config =
                GenerateContentConfig.builder()
                        .systemInstruction(
                                Content.fromParts(
                                        Part.fromText(
                                                "You are a safe, responsible and helpful healthcare information assistant."
                                        )
                                )
                        )
                        .build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3.6-flash",
                        prompt,
                        config
                );

        String botResponse = response.text();

        String userEmail = (String) session.getAttribute("userEmail");

        ChatMessage chatMessage =
                new ChatMessage(message, botResponse, LocalDateTime.now(), userEmail);

        chatMessageRepository.save(chatMessage);

        return botResponse;
    }
    @GetMapping("/chat/history")
    public List<ChatMessage> getChatHistory(HttpSession session) {

        String userEmail = (String) session.getAttribute("userEmail");

        if (userEmail == null) {
            return List.of();
        }

        return chatMessageRepository.findByUserEmailOrderByTimestampAsc(userEmail);
    }
    @DeleteMapping("/chat/history")
    public String deleteChatHistory() {
        chatMessageRepository.deleteAll();
        return "Chat history deleted successfully.";
    }
}