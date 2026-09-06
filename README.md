# 🏥 Healthcare ChatBot 🤖

An AI-powered healthcare chatbot that provides quick and helpful health-related guidance using Google Gemini.

## ✨ Features

- 👤 User registration and login
- 🔐 Session-based user authentication
- 🤖 AI-powered healthcare responses using Google Gemini
- 💬 Interactive chatbot
- 📋 User-specific chat history
- 🗑️ Delete chat history
- 🚪 Logout functionality
- 🚨 Emergency warning for potentially serious symptoms
- 💾 MySQL database storage
- ⚡ Quick health suggestions
- 📱 Clean and user-friendly interface

## 🛠️ Technologies Used

- ☕ Java 17
- 🌱 Spring Boot, Spring Web, Spring Data JPA
- 🤖 Google Gemini API
- 🗄️ MySQL
- 🌐 HTML, CSS & JavaScript
- 💻 IntelliJ IDEA
- 🐙 Git & GitHub
- Maven

## 🚀 Current Status

The application currently supports:

- ✅ User Signup & Login
- ✅ AI Healthcare Chatbot
- ✅ User-specific Chat History
- ✅ Delete Chat History
- ✅ Logout
- ✅ Emergency Warning System
- ✅ MySQL Database Integration
- ✅ Google Gemini Integration

## ⚠️ Medical Disclaimer

🚨 This chatbot is designed for educational and informational purposes only.

It does not replace professional medical advice, diagnosis, or treatment.

In case of a medical emergency, please contact your local emergency medical services or consult a qualified healthcare professional.

## 🏗️ Project Structure

```text
Healthcare-ChatBot
│
├── src
│   └── main
│       ├── java
│       │   └── com.healthcare.Healthcare.ChatBot
│       │       ├── HealthcareChatBotApplication.java
│       │       ├── ChatBotController.java
│       │       ├── ChatRequest.java
│       │       ├── ChatMessage.java
│       │       ├── User.java
│       │       └── UserRepository.java
│       │
│       └── resources
│           ├── static
│           │   ├── index.html
│           │   ├── login.html
│           │   └── signup.html
│           │
│           └── application.properties
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md

