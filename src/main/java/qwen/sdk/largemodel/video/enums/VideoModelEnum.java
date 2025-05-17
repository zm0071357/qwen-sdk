package qwen.sdk.largemodel.video.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 对话模型枚举
 * https://help.aliyun.com/zh/model-studio/models?spm=a2c4g.11186623.help-menu-2400256.d_0_0_2.31356ff2z7n5cr#a42bdc182c8ee
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum VideoModelEnum {

    WANX_21_T2V_PLUS("wanx2.1-t2v-plus", "生成细节更丰富，画面更具质感"),
    WANX_21_T2V_TURBO("wanx2.1-t2v-turbo", "生成速度更快，表现均衡"),
    WANX_21_KF2V_PLUS("wanx2.1-kf2v-plus", "提供首帧和尾帧图片，便能根据提示词生成一段丝滑流畅的动态视频"),
    ;

    private String model;
    private String info;
}
