package qwen.sdk.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Before;
import org.junit.Test;
import qwen.sdk.factory.Configuration;
import qwen.sdk.factory.ModelFactory;
import qwen.sdk.factory.defaults.DefaultModelFactory;
import qwen.sdk.largemodel.chat.impl.ChatServiceImpl;
import qwen.sdk.largemodel.chat.model.ChatMutiResponse;
import qwen.sdk.largemodel.chat.model.ChatMutiStreamResponse;
import qwen.sdk.largemodel.chat.model.ChatRequest;
import qwen.sdk.largemodel.chat.model.ChatResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class ChatTest {

    private ChatServiceImpl chatServiceImpl;

    @Before
    public void init() {
        Configuration configuration = new Configuration("");
        ModelFactory modelFactory = new DefaultModelFactory(configuration);
        this.chatServiceImpl = modelFactory.chatService();
    }

    @Test
    public void testChat() throws IOException {
        List<ChatRequest.Input.Message> messages = new ArrayList<>();
        messages.add(ChatRequest.Input.Message.builder()
                .role("system")
                .content("You are a helpful assistant.")
                .build());
        messages.add(ChatRequest.Input.Message.builder()
                .role("user")
                .content("介绍《黑神话：悟空》")
                .build());
        ChatRequest request = ChatRequest.builder()
                .model("qwen-plus")
                .input(ChatRequest.Input.builder()
                        .messages(messages)
                        .build())
                .parameters(ChatRequest.Parameters.builder()
                                .resultFormat("message")
                                .enableSearch(true)
                                .searchOptions(ChatRequest.Parameters.SearchOptions.builder()
                                        .enableSource(true)
                                        .forcedSearch(true)
                                        .build())
                                .build())
                .build();
        ChatResponse response = chatServiceImpl.chat(request);
        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("返回结果:{}", JSON.toJSONString(response));
    }

    @Test
    public void testChatStream() throws IOException, InterruptedException {
        List<ChatRequest.Input.Message> messages = new ArrayList<>();
        messages.add(ChatRequest.Input.Message.builder()
                .role("system")
                .content("You are a helpful assistant.")
                .build());
        messages.add(ChatRequest.Input.Message.builder()
                .role("user")
                .content("介绍《黑神话：悟空》")
                .build());
        ChatRequest request = ChatRequest.builder()
                .model("qwen-plus")
                .input(ChatRequest.Input.builder()
                        .messages(messages)
                        .build())
                .parameters(ChatRequest.Parameters.builder()
                        .resultFormat("message")
                        .incrementalOutput(true)
//                        .enableSearch(true)
//                        .searchOptions(ChatRequest.Parameters.SearchOptions.builder()
//                                .enableSource(true)
//                                .forcedSearch(true)
//                                .build())
                        .build())
                .build();
        log.info("请求参数:{}", JSON.toJSONString(request));
        EventSource eventSource = chatServiceImpl.chatStream(request, new EventSourceListener() {
            @Override
            public void onEvent(@NotNull EventSource eventSource, @Nullable String id, @Nullable String type, @NotNull String data) {
                log.info("测试结果:{}", data);
                ChatResponse chatResponse = JSON.parseObject(data, ChatResponse.class);
                log.info("对话结果:{}", JSON.toJSONString(chatResponse));
            }

            @Override
            public void onFailure(@NotNull EventSource eventSource, @Nullable Throwable t, @Nullable Response response) {
                log.info("错误:{}", response.message());
            }
        });
        new CountDownLatch(1).await();
    }

    @Test
    public void testChatWithMultimodal() throws IOException {
        List<ChatRequest.Input.Message> messages = new ArrayList<>();

        List<ChatRequest.Input.Message.Content> systemContent = new ArrayList<>();
        systemContent.add(ChatRequest.Input.Message.Content.builder().text("你是一个有用的助手").build());
        messages.add(ChatRequest.Input.Message.builder()
                .role("system")
                .content(systemContent)
                .build());

        List<ChatRequest.Input.Message.Content> userContent = new ArrayList<>();
        userContent.add(ChatRequest.Input.Message.Content.builder()
                .video("https://help-static-aliyun-doc.aliyuncs.com/file-manage-files/zh-CN/20241115/cqqkru/1.mp4").fps(2)
                .build());
        userContent.add(ChatRequest.Input.Message.Content.builder().text("描述这个视频").build());
        messages.add(ChatRequest.Input.Message.builder()
                .role("user")
                .content(userContent)
                .build());

        ChatRequest request = ChatRequest.builder()
                .model("qwen-vl-plus")
                .input(ChatRequest.Input.builder()
                        .messages(messages)
                        .build())
                .parameters(ChatRequest.Parameters.builder()
                        .resultFormat("message")
//                        .enableSearch(true)
//                        .searchOptions(ChatRequest.Parameters.SearchOptions.builder()
//                                .enableSource(true)
//                                .forcedSearch(true)
//                                .build())
                        .build())
                .build();
        ChatMutiResponse response = chatServiceImpl.chatWithMultimodal(request);
        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("返回结果:{}", JSON.toJSONString(response));
    }

    @Test
    public void testChatWithMultimodalStream() throws IOException, InterruptedException {
        List<ChatRequest.Input.Message> messages = new ArrayList<>();
        List<ChatRequest.Input.Message.Content> systemContent = new ArrayList<>();
        systemContent.add(ChatRequest.Input.Message.Content.builder().text("你是一个有用的助手").build());
        messages.add(ChatRequest.Input.Message.builder()
                .role("system")
                .content(systemContent)
                .build());

        List<ChatRequest.Input.Message.Content> userContent = new ArrayList<>();
//        userContent.add(ChatRequest.Input.Message.Content.builder()
//                .video("https://help-static-aliyun-doc.aliyuncs.com/file-manage-files/zh-CN/20241115/cqqkru/1.mp4").fps(2)
//                .build());
        userContent.add(ChatRequest.Input.Message.Content.builder().text("1+1是多少").build());
        messages.add(ChatRequest.Input.Message.builder()
                .role("user")
                .content(userContent)
                .build());
        ChatRequest request = ChatRequest.builder()
                .model("qwen-vl-plus")
                .input(ChatRequest.Input.builder()
                        .messages(messages)
                        .build())
                .parameters(ChatRequest.Parameters.builder()
                        .incrementalOutput(true)
                        .resultFormat("message")
//                        .enableSearch(true)
//                        .searchOptions(ChatRequest.Parameters.SearchOptions.builder()
//                                .enableSource(true)
//                                .forcedSearch(true)
//                                .build())
                        .build())
                .build();
        log.info("请求参数:{}", JSON.toJSONString(request));

        StringBuilder sb = new StringBuilder();
        EventSource eventSource = chatServiceImpl.chatWithMultimodalWithStream(request, new EventSourceListener() {
            @Override
            public void onEvent(@NotNull EventSource eventSource, @Nullable String id, @Nullable String type, @NotNull String data) {
                log.info("测试结果:{}", data);
                ChatMutiStreamResponse response = JSON.parseObject(data, ChatMutiStreamResponse.class);
                log.info("json:{}", JSON.toJSONString(response));
                log.info("text:{}", response.getOutput().getChoices().get(0).getMessage().getContent().get(0).getText());
                sb.append(response.getOutput().getChoices().get(0).getMessage().getContent().get(0).getText());
            }

            @Override
            public void onClosed(@NotNull EventSource eventSource) {
                log.info(String.valueOf(sb));
            }
        });
        new CountDownLatch(1).await();
    }

}
