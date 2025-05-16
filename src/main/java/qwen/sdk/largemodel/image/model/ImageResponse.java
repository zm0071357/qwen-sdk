package qwen.sdk.largemodel.image.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

/**
 * 文生图响应体
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageResponse {
    private String request_id;
    private OutPut output;
    private String code;
    private String message;

    @Getter
    public static class OutPut {
        private String task_status;
        private String task_id;
    }
}
