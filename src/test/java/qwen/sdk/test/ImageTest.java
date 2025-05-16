package qwen.sdk.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import qwen.sdk.factory.Configuration;
import qwen.sdk.factory.ModelFactory;
import qwen.sdk.factory.defaults.DefaultModelFactory;
import qwen.sdk.largemodel.image.impl.ImageServiceImpl;
import qwen.sdk.largemodel.image.model.ImageRequest;
import qwen.sdk.largemodel.image.model.ImageResponse;
import qwen.sdk.largemodel.image.model.ResultResponse;

import java.io.IOException;

@Slf4j
public class ImageTest {
    private ImageServiceImpl imageServiceImpl;

    @Before
    public void init() {
        Configuration configuration = new Configuration("");
        ModelFactory modelFactory = new DefaultModelFactory(configuration);
        this.imageServiceImpl = modelFactory.imageService();
    }

    @Test
    public void testImageSynthesis() throws IOException {
        ImageRequest request = ImageRequest.builder()
                .model("wanx2.1-t2i-turbo")
                .input(ImageRequest.Input.builder().prompt("一间有着精致窗户的花店，漂亮的木质门，摆放着花朵").build())
                .parameters(ImageRequest.Parameters.builder().size("1024*1024").n(1).build())
                .build();
        ImageResponse response = imageServiceImpl.imageSynthesis(request);
        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("返回结果:{}", JSON.toJSONString(response));
    }

    @Test
    public void testResult() throws IOException {
        String taskId = "";
        ResultResponse response = imageServiceImpl.result(taskId);
        log.info("请求参数:{}", JSON.toJSONString(taskId));
        log.info("返回结果:{}", JSON.toJSONString(response));
    }

}
