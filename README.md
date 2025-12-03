# Generative AI Spring Boot Integration

This project demonstrates a local integration of Generative AI using Spring Boot and Ollama. It leverages **Spring AI** to communicate with a locally running Ollama instance.

## Overview

The application exposes a REST API that accepts chat messages and forwards them to a local Ollama model (specifically `llama3.2` by default). It serves as a foundational example for building AI-powered applications with Spring Boot.

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java 25** (as specified in `pom.xml`)
- **Maven**
- **Ollama**: You need a running instance of Ollama.
  - Install Ollama from [ollama.com](https://ollama.com/).
  - Pull the required model:
    ```bash
    ollama pull llama3.2
    ```

## Configuration

The application is configured via `src/main/resources/application.yaml`.

- **Server Port**: `8080`
- **Ollama Base URL**: `http://localhost:11434`
- **Model**: `llama3.2`
- **Temperature**: `0.7`

You can modify these settings in the `application.yaml` file.

## Installation & Running

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    cd generative
    ```

2.  **Build the project:**
    ```bash
    ./mvnw clean install
    ```

3.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

## Usage

### Chat Endpoint

**URL**: `POST /api/model/chat`

**Description**: Sends a prompt to the Ollama model and receives a generated response.

**Request Body** (`application/json`):

```json
{
  "messages": [
    {
      "role": "user",
      "content": "Tell me a joke about Java developers."
    }
  ]
}
```

**Response Body** (`application/json`):

```json
{
  "model": "llama3.2",
  "contentFromPrompt": "Why do Java developers wear glasses? Because they don't C#!"
}
```

## Project Structure

- **Controller**: `OllamaController` - Handles HTTP requests.
- **Service**: `OllamaService` - Contains the business logic for interacting with the ChatModel.
- **DTOs**: `ChatRequestLocal`, `ChatResponseLocal` - Data Transfer Objects for API communication.

## Dependencies

- `spring-boot-starter-web`
- `spring-ai-starter-model-ollama`
