package qwen.sdk.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import qwen.sdk.factory.Configuration;
import qwen.sdk.factory.ModelFactory;
import qwen.sdk.factory.defaults.DefaultModelFactory;
import qwen.sdk.largemodel.video.model.ResultResponse;
import qwen.sdk.largemodel.video.impl.VideoServiceImpl;
import qwen.sdk.largemodel.video.model.VideoRequest;
import qwen.sdk.largemodel.video.model.VideoResponse;

import java.io.IOException;

@Slf4j
public class VideoTest {

    private VideoServiceImpl videoServiceImpl;

    @Before
    public void init() {
        Configuration configuration = new Configuration("");
        ModelFactory modelFactory = new DefaultModelFactory(configuration);
        this.videoServiceImpl = modelFactory.videoService();
    }

    @Test
    public void testVideoSynthesis() throws IOException {
        VideoRequest request = VideoRequest.builder()
                .model("wanx2.1-t2v-turbo")
                .input(VideoRequest.Input.builder()
                        .prompt("一只猫在草地上奔跑")
                        .imgUrl("https://cdn.translate.alibaba.com/r/wanx-demo-1.png")
                        .build())
                .parameters(VideoRequest.Parameters.builder()
                        .resolution("720P")
                        .promptExtend(true)
                        .build())
                .build();
        VideoResponse response = videoServiceImpl.videoSynthesis(request);
        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("返回结果:{}", JSON.toJSONString(response));
    }

    @Test
    public void testVideoSynthesisWithImages() throws IOException {
        VideoRequest request = VideoRequest.builder()
                .model("wanx2.1-kf2v-plus")
                .input(VideoRequest.InputExtend.builder()
                        .prompt("写实风格，一只黑色小猫好奇地看向天空，镜头从平视逐渐上升，最后俯拍小猫好奇的眼神。")
                        .firstFrameUrl("https://wanx.alicdn.com/material/20250318/first_frame.png")
                        .lastFrameUrl("https://wanx.alicdn.com/material/20250318/last_frame.png")
                        .build())
                .parameters(VideoRequest.Parameters.builder()
                        .resolution("720P")
                        .promptExtend(true)
                        .build())
                .build();
        VideoResponse response = videoServiceImpl.videoSynthesisWithImages(request);
        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("返回结果:{}", JSON.toJSONString(response));
    }

    @Test
    public void testResult() throws IOException {
        String taskId = "";
        ResultResponse response = videoServiceImpl.result(taskId);
        log.info("请求参数:{}", JSON.toJSONString(taskId));
        log.info("返回结果:{}", JSON.toJSONString(response));
    }
}
