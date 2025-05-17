package qwen.sdk.largemodel.video.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 文生视频分辨率枚举
 * https://help.aliyun.com/zh/model-studio/text-to-video-api-reference?spm=a2c4g.11186623.help-menu-2400256.d_2_3_2.1f1b2509icvFEi
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SizeEnum {

    /**
     * 480P
     * wanx2.1-t2v-turbo 支持 480P 和 720P 对应的所有分辨率
     */
    SIXTEEN_NINE_480P("16:9", "832*480"),
    NINE_SIXTEEN_480P("9:16", "480*832"),
    ONE_ONE_480P("1:1", "624*624"),


    /**
     * 720P
     * wanx2.1-t2v-plus 仅支持 720P 对应的所有分辨率
     */
    SIXTEEN_NINE_720P("16:9", "1280*720"),
    NINE_SIXTEEN_720P("9:16", "720*1280"),
    ONE_ONE_720P("1:1", "960*960"),
    THREE_FOUR_720P("3:4", "832*1088"),
    FOUR_THREE_720P("4:3", "1088*832")
    ;

    private String aspect_ratio;
    private String resolution;

}
