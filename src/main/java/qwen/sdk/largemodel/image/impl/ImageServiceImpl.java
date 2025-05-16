package qwen.sdk.largemodel.image.impl;

import qwen.sdk.factory.Configuration;
import qwen.sdk.largemodel.chat.model.ChatResponse;
import qwen.sdk.largemodel.image.ImageService;
import qwen.sdk.largemodel.image.model.ImageRequest;
import qwen.sdk.largemodel.image.model.ImageResponse;
import qwen.sdk.largemodel.image.model.ResultResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ImageServiceImpl {

    private ImageService imageService;

    private Configuration configuration;

    public ImageServiceImpl(ImageService imageService, Configuration configuration) {
        this.imageService = imageService;
        this.configuration = configuration;
    }

    public ImageResponse imageSynthesis(ImageRequest imageRequest) throws IOException {
        Call<ImageResponse> call = imageService.imageSynthesis(configuration.getAuthorization(), imageRequest);
        Response<ImageResponse> execute = call.execute();
        return execute.body();
    }

    public ResultResponse result(String taskId) throws IOException {
        Call<ResultResponse> call = imageService.result(configuration.getAuthorization(), taskId);
        Response<ResultResponse> execute = call.execute();
        return execute.body();
    }
}
