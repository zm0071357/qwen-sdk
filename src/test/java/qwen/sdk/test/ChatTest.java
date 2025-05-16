package qwen.sdk.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import qwen.sdk.factory.Configuration;
import qwen.sdk.factory.ModelFactory;
import qwen.sdk.factory.defaults.DefaultModelFactory;
import qwen.sdk.largemodel.chat.impl.ChatServiceImpl;
import qwen.sdk.largemodel.chat.model.ChatRequest;
import qwen.sdk.largemodel.chat.model.ChatResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        ChatResponse response = chatServiceImpl.chatWithMultimodal(request);
        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("返回结果:{}", JSON.toJSONString(response));
    }

}
