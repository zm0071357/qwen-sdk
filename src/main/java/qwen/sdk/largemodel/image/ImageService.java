package qwen.sdk.largemodel.image;

import qwen.sdk.largemodel.image.model.ImageRequest;
import qwen.sdk.largemodel.image.model.ImageResponse;
import qwen.sdk.largemodel.image.model.ResultResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface ImageService {

    @POST("/api/v1/services/aigc/text2image/image-synthesis")
    @Headers({"X-DashScope-Async: enable", "Content-Type: application/json"})
    Call<ImageResponse> imageSynthesis(@Header("Authorization") String authorization,
                             @Body ImageRequest request);

    @GET("https://dashscope.aliyuncs.com/api/v1/tasks/{task_id}")
    Call<ResultResponse> result(@Header("Authorization") String authorization,
                                @Path("task_id") String taskId);
}
