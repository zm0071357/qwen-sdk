package qwen.sdk.largemodel.chat.impl;

import qwen.sdk.factory.Configuration;
import qwen.sdk.largemodel.chat.ChatService;
import qwen.sdk.largemodel.chat.model.ChatMutiResponse;
import qwen.sdk.largemodel.chat.model.ChatRequest;
import qwen.sdk.largemodel.chat.model.ChatResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ChatServiceImpl {

    private ChatService chatService;

    private Configuration configuration;

    public ChatServiceImpl(ChatService chatService, Configuration configuration) {
        this.chatService = chatService;
        this.configuration = configuration;
    }

    public ChatResponse chat(ChatRequest chatRequest) throws IOException {
        Call<ChatResponse> call = chatService.chat(configuration.getAuthorization(), chatRequest);
        Response<ChatResponse> execute = call.execute();
        return execute.body();
    }

    public ChatMutiResponse chatWithMultimodal(ChatRequest chatRequest) throws IOException {
        Call<ChatMutiResponse> call = chatService.chatWithMultimodal(configuration.getAuthorization(), chatRequest);
        Response<ChatMutiResponse> execute = call.execute();
        return execute.body();
    }

}
