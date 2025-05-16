package qwen.sdk.largemodel.image.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * 文生图请求体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequest {

    private String model;

    private Input input;

    private Parameters parameters;

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Input {
        private String prompt;
        private String negative_prompt;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Parameters {
        private String size;
        private int n;
        private boolean prompt_extend;
        private boolean watermark;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class InputExtend extends Input {
        private String function;
        private String base_image_url;
        private String mask_image_url;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class ParametersExtend extends Parameters {
        private Float strength;
        private Float top_scale;
        private Float bottom_scale;
        private Float left_scale;
        private Float right_scale;
        private Integer upscale_factor;
    }

}
