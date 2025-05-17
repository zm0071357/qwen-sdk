package qwen.sdk.largemodel.image.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 图像模型枚举
 * https://help.aliyun.com/zh/model-studio/models?spm=a2c4g.11186623.0.0.80926ff23T1L2R#4611ffaa38hnp
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ImageEnum {

    /**
     * 文生图
     */
    WANX_21_T2I_PLUS("wanx2.1-t2i-plus", "生成图像细节更丰富，速度较慢"),
    WANX_21_T2I_TURBO("wanx2.1-t2i-turbo", "生成速度快、效果全面、性价比高"),
    WANX_20_T2I_TURBO("wanx2.0-t2i-turbo", "擅长质感人像，速度中等、成本较低"),

    /**
     * 通用图像编辑
     */
    WANX_21_IMAGEEDIT("wanx2.1-imageedit", "适用于扩图、去水印、风格迁移、图像修复、图像美化等场景"),

    ;

    private String model;
    private String info;
}
