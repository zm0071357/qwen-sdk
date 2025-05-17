package qwen.sdk.largemodel.video.impl;

import qwen.sdk.factory.Configuration;
import qwen.sdk.largemodel.video.VideoService;
import qwen.sdk.largemodel.video.model.ResultResponse;
import qwen.sdk.largemodel.video.model.VideoRequest;
import qwen.sdk.largemodel.video.model.VideoResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class VideoServiceImpl {

    private VideoService videoService;

    private Configuration configuration;

    public VideoServiceImpl(VideoService videoService, Configuration configuration) {
        this.videoService = videoService;
        this.configuration = configuration;
    }

    public VideoResponse videoSynthesis(VideoRequest request) throws IOException {
        Call<VideoResponse> call = videoService.videoSynthesis(configuration.getAuthorization(), request);
        Response<VideoResponse> execute = call.execute();
        return execute.body();
    }

    public VideoResponse videoSynthesisWithImages(VideoRequest request) throws IOException {
        Call<VideoResponse> call = videoService.videoSynthesisWithImages(configuration.getAuthorization(), request);
        Response<VideoResponse> execute = call.execute();
        return execute.body();
    }

    public ResultResponse result(String taskId) throws IOException {
        Call<ResultResponse> call = videoService.result(configuration.getAuthorization(), taskId);
        Response<ResultResponse> execute = call.execute();
        return execute.body();
    }


}
