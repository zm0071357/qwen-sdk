package qwen.sdk.largemodel.chat;

import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import qwen.sdk.largemodel.chat.model.ChatMutiResponse;
import qwen.sdk.largemodel.chat.model.ChatRequest;
import qwen.sdk.largemodel.chat.model.ChatResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * 对话服务
 */
public interface ChatService {

    String chatStreamUrl = "/api/v1/services/aigc/text-generation/generation";

    String chatWithMultimodalStreamUrl = "/api/v1/services/aigc/multimodal-generation/generation";

    /**
     * 对话 - 文本输入、联网搜索
     * @param authorization 请求头
     * @param request 对话请求体
     * @return
     */
    @POST("/api/v1/services/aigc/text-generation/generation")
    @Headers("Content-Type: application/json")
    Call<ChatResponse> chat(@Header("Authorization") String authorization,
                            @Body ChatRequest request);

    /**
     * 对话 - 流式输出
     * @param request
     * @param eventSourceListener
     * @return
     */
    EventSource chatWithStream(ChatRequest request,
                               EventSourceListener eventSourceListener);

    /**
     * 多模态对话
     * @param authorization 请求头
     * @param request 对话请求体
     * @return
     */
    @POST("/api/v1/services/aigc/multimodal-generation/generation")
    @Headers("Content-Type: application/json")
    Call<ChatMutiResponse> chatWithMultimodal(@Header("Authorization") String authorization,
                                              @Body ChatRequest request);

    /**
     * 多模态对话 - 流式输出
     * @param request
     * @param eventSourceListener
     * @return
     */
    EventSource chatWithMultimodalWithStream(ChatRequest request,
                                             EventSourceListener eventSourceListener);
}
