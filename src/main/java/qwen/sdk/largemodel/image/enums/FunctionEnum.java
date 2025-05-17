package qwen.sdk.largemodel.image.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 图像编辑枚举
 * https://help.aliyun.com/zh/model-studio/wanx-image-edit?spm=a2c4g.11186623.help-menu-2400256.d_0_5_1.11bf1d1cY0hOii#3be4a1e9569kk
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum FunctionEnum {

    STYLIZATION_ALL("stylization_all", "全局风格化。该功能根据指定风格对整张图像进行风格迁移，目前支持两种风格：法国绘本风格、金箔艺术风格"),
    STYLIZATION_LOCAL("stylization_local", "局部风格化。该功能根据指定风格对图像的局部区域进行风格迁移，目前支持八种风格：冰雕、云朵、花灯、木板、青花瓷、毛茸茸、毛线、气球"),
    DESCRIPTION_EDIT("description_edit", "指令编辑。该功能通过指令即可完成增加或修改操作。与局部重绘不同的是，指令编辑无需指定区域，更适合无需严格定位编辑区域的场景"),
    REMOVE_WATERMARK("remove_watermark", "去文字水印。该功能可有效去除图像中的文字（中英文）及水印"),
    EXPAND("expand", "扩图。该功能支持对图像在上、下、左、右四个方向按比例扩图"),
    SUPER_RESOLUTION("super_resolution", "图像超分。该功能支持高清放大，能够将模糊或低分辨率图像转化为清晰、高分辨率的图像，同时在放大过程中增强图像细节"),
    COLORIZATION("colorization", "图像上色。该功能支持将黑白或灰度图像转化为彩色图像（黑白/灰度 → 彩色）"),
    DOODLE("doodle", "线稿生图。该功能默认会从输入的 RGB 图像中提取线稿，然后基于线稿和提示词生成图像（RGB图像 → 线稿 → 新图）"),
    CONTROL_CARTOON_FEATURE("control_cartoon_feature", "垫图。该功能基于参考图和提示词生成新图，目前仅支持卡通形象"),
    ;

    private String function;
    private String info;
}
