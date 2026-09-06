# 🏥 Healthcare ChatBot

An AI-powered healthcare information chatbot built using **Java, Spring Boot, Gemini AI, MySQL, HTML and CSS**.

The chatbot provides general healthcare information, detects potential emergency symptoms, and stores chat history in a MySQL database.

---

## ✨ Features

- 🤖 AI-powered healthcare responses using Google Gemini
- 💬 Interactive chatbot interface
- 🚨 Emergency symptom detection
- 🗄️ Chat history stored in MySQL
- 👤 User registration and login
- ⚡ Quick health question buttons
- 🧹 Clear chat functionality
- 📋 View previous chat history
- 🗑️ Delete chat history
- 📱 Simple and user-friendly interface
- 🔐 API keys and database passwords stored using environment variables

---

## 🛠️ Technologies Used

### Backend
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate

### AI
- Google Gemini API
- Google GenAI Java SDK

### Database
- MySQL

### Frontend
- HTML
- CSS
- JavaScript

### Development Tools
- IntelliJ IDEA
- MySQL Workbench
- Git
- GitHub
- Maven

---

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
