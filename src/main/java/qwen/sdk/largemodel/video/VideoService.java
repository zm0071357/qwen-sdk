package qwen.sdk.largemodel.video;

import qwen.sdk.largemodel.video.model.ResultResponse;
import qwen.sdk.largemodel.video.model.VideoRequest;
import qwen.sdk.largemodel.video.model.VideoResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface VideoService {

    /**
     * 图生视频 - 基于首帧
     * 文生视频
     * @param authorization 请求头
     * @param request 文图生视频请求体
     * @return
     */
    @POST("/api/v1/services/aigc/video-generation/video-synthesis")
    @Headers({"X-DashScope-Async: enable", "Content-Type: application/json"})
    Call<VideoResponse> videoSynthesis(@Header("Authorization") String authorization,
                                       @Body VideoRequest request);

    /**
     * 图生视频 - 基于首尾帧
     * @param authorization 请求头
     * @param request 文图生视频请求体
     * @return
     */
    @POST("/api/v1/services/aigc/image2video/video-synthesis")
    @Headers({"X-DashScope-Async: enable", "Content-Type: application/json"})
    Call<VideoResponse> videoSynthesisWithImages(@Header("Authorization") String authorization,
                                       @Body VideoRequest request);

    /**
     * 根据任务ID查询结果
     * @param authorization 请求体
     * @param taskId 任务ID
     * @return
     */
    @GET("/api/v1/tasks/{task_id}")
    Call<ResultResponse> result(@Header("Authorization") String authorization,
                                @Path("task_id") String taskId);
}
