package qwen.sdk.largemodel.image;

import qwen.sdk.largemodel.image.model.ImageRequest;
import qwen.sdk.largemodel.image.model.ImageResponse;
import qwen.sdk.largemodel.image.model.ResultResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface ImageService {

    /**
     * 文生图v2
     * @param authorization 请求头
     * @param request 文生图请求体
     * @return
     */
    @POST("/api/v1/services/aigc/text2image/image-synthesis")
    @Headers({"X-DashScope-Async: enable", "Content-Type: application/json"})
    Call<ImageResponse> imageSynthesis(@Header("Authorization") String authorization,
                             @Body ImageRequest request);

    /**
     * 根据任务ID查询结果
     * @param authorization 请求体
     * @param taskId 任务ID
     * @return
     */
    @GET("https://dashscope.aliyuncs.com/api/v1/tasks/{task_id}")
    Call<ResultResponse> result(@Header("Authorization") String authorization,
                                @Path("task_id") String taskId);

    /**
     * 通用图像编辑
     * @param authorization 请求体
     * @param request 文生图请求体
     * @return
     */
    @POST("/api/v1/services/aigc/image2image/image-synthesis")
    @Headers({"X-DashScope-Async: enable", "Content-Type: application/json"})
    Call<ImageResponse> imageSynthesisByEdit(@Header("Authorization") String authorization,
                                       @Body ImageRequest request);

}
