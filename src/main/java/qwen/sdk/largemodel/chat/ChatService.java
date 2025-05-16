package qwen.sdk.largemodel.chat;

import qwen.sdk.largemodel.chat.model.ChatRequest;
import qwen.sdk.largemodel.chat.model.ChatResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * 对话服务
 */
public interface ChatService {

    /**
     * 对话 - 文本输入、流式输出、联网搜索
     * @param authorization 请求头
     * @param request 对话请求体
     * @return
     */
    @POST("/api/v1/services/aigc/text-generation/generation")
    @Headers("Content-Type: application/json")
    Call<ChatResponse> chat(@Header("Authorization") String authorization,
                            @Body ChatRequest request);

    /**
     * 多模态对话 - 图像输入、视频输入、音频输入
     * @param authorization 请求头
     * @param request 对话请求体
     * @return
     */
    @POST("/api/v1/services/aigc/multimodal-generation/generation")
    @Headers("Content-Type: application/json")
    Call<ChatResponse> chatWithMultimodal(@Header("Authorization") String authorization,
                            @Body ChatRequest request);

}
