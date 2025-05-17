package qwen.sdk.largemodel.video.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * 文图生视频响应体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoResponse {
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
