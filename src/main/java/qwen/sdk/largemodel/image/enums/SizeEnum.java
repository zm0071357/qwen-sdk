package qwen.sdk.largemodel.image.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 文生图v2分辨率枚举
 * https://help.aliyun.com/zh/model-studio/text-to-image-v2-api-reference?spm=a2c4g.11186623.help-menu-2400256.d_2_2_0.7ce44a3eKrczsS
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SizeEnum {

    ONE_ONE("1:1", "1440*1440"),
    SIXTEEN_NINE("16:9", "1280*720"),
    NINE_SIXTEEN("9:16", "720*1280"),
    FOUR_THREE("4:3", "1440*1080"),
    THREE_FOUR("3:4", "1080*1440"),
    THREE_TWO("3:2", "960*1440"),
    TWO_THREE("2:3", "1440*960"),
    ;
    private String aspect_ratio;
    private String resolution;
}
