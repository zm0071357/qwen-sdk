package qwen.sdk.largemodel.chat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 对话模型枚举
 * https://help.aliyun.com/zh/model-studio/models?spm=a2c4g.11186623.0.0.80926ff23T1L2R#d54c2c9409nml
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ChatModelEnum {

    /**
     * QwQ模型 - 达到DeepSeek R1满血版水平
     */
    QWQ_PLUS("qwq-plus", "稳定版"),
    QWQ_PLUS_LATEST("qwq-plus-latest", "最新版"),

    /**
     * 通义千问-MAX
     */
    QWEN_MAX("qwen-max", "稳定版"),
    QWEN_MAX_LATEST("qwen-max-latest", "最新版"),

    /**
     * 通义千问-PLUS
     */
    QWEN_PLUS("qwen-plus", "稳定版"),
    QWEN_PLUS_LATEST("qwen-plus-latest", "最新版"),

    /**
     * 通义千问-Turbo
     */
    QWEN_TURBO("qwen-turbo", "稳定版"),
    QWEN_TURBO_LATEST("qwen-turbo-latest", "最新版"),


    /**
     * 通义千问-Omni
     */
    QWEN_OMNI_TURBO("qwen-omni-turbo", "稳定版"),
    QWEN_OMNI_TURBO_LATEST("qwen-omni-turbo-latest", "最新版"),

    /**
     * 通义千问-VL
     */
    QWEN_VL_MAX("qwen-vl-max", "稳定版"),
    QWEN_VL_MAX_LATEST("qwen-vl-max-latest", "最新版"),
    QWEN_VL_PLUS("qwen-vl-plus", "稳定版"),
    QWEN_VL_PLUS_LATEST("qwen-vl-plus-latest", "最新版"),

    /**
     * 通义千问-Audio
     */
    QWEN_AUDIO_TURBO("qwen-audio-turbo", "稳定版"),
    QWEN_AUDIO_TURBO_LATEST("qwen-audio-turbo", "最新版"),
    ;

    private String model;
    private String info;
}
