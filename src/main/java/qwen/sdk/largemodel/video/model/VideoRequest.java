package qwen.sdk.largemodel.video.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * 文图生视频请求体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequest {

    private String model;

    private Input input;

    private Parameters parameters;

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Input {
        private String prompt;

        @JsonProperty("img_url")
        private String imgUrl;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Parameters {
        private String resolution;

        @JsonProperty("prompt_extend")
        private boolean promptExtend;

        private Integer duration;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class InputExtend extends Input {
        @JsonProperty("first_frame_url")
        private String firstFrameUrl;

        @JsonProperty("last_frame_url")
        private String lastFrameUrl;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class ParametersExtend extends Parameters {
        private String size;
    }
}
