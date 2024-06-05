package com.bernardi.ScreenSound.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ChatGPT {

	public static String getData(String text) {
		OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Tell me about this artist: " + text)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var response = service.createCompletion(requisicao);
        return response.getChoices().get(0).getText();
    }
	}

