package qwen.sdk.largemodel.chat.impl;

import cn.hutool.http.ContentType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
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

    private final EventSource.Factory factory;

    public ChatServiceImpl(ChatService chatService, Configuration configuration) {
        this.chatService = chatService;
        this.configuration = configuration;
        this.factory = configuration.createRequestFactory();
    }

    public ChatResponse chat(ChatRequest chatRequest) throws IOException {
        Call<ChatResponse> call = chatService.chat(configuration.getAuthorization(), chatRequest);
        Response<ChatResponse> execute = call.execute();
        return execute.body();
    }

    public EventSource chatStream(ChatRequest chatRequest, EventSourceListener eventSourceListener) throws IOException {
        Request request = new Request.Builder()
                .url(configuration.getApiHost().concat(chatService.chatStreamUrl))
                .addHeader("Authorization", configuration.getAuthorization())
                .addHeader("X-DashScope-SSE", "enable")
                .post(RequestBody.create(MediaType.parse(ContentType.JSON.getValue()), new ObjectMapper().writeValueAsString(chatRequest)))
                .build();
        return factory.newEventSource(request, eventSourceListener);
    }

    public ChatMutiResponse chatWithMultimodal(ChatRequest chatRequest) throws IOException {
        Call<ChatMutiResponse> call = chatService.chatWithMultimodal(configuration.getAuthorization(), chatRequest);
        Response<ChatMutiResponse> execute = call.execute();
        return execute.body();
    }

    public EventSource chatWithMultimodalWithStream(ChatRequest chatRequest, EventSourceListener eventSourceListener) throws JsonProcessingException {
        Request request = new Request.Builder()
                .url(configuration.getApiHost().concat(chatService.chatWithMultimodalStreamUrl))
                .addHeader("Authorization", configuration.getAuthorization())
                .addHeader("X-DashScope-SSE", "enable")
                .post(RequestBody.create(MediaType.parse(ContentType.JSON.getValue()), new ObjectMapper().writeValueAsString(chatRequest)))
                .build();
        return factory.newEventSource(request, eventSourceListener);
    }

}
