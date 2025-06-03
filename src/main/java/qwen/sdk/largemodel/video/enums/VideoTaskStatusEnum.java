package qwen.sdk.largemodel.video.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 视频生成任务状态枚举
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum VideoTaskStatusEnum {

    PENDING("PENDING", "任务排队中"),
    RUNNING("RUNNING", "任务处理中"),
    SUCCEEDED("SUCCEEDED", "任务执行成功"),
    FAILED("FAILED", "任务执行失败"),
    CANCELED("CANCELED", "任务取消成功"),
    UNKNOWN("UNKNOWN", "任务不存在或状态未知"),
    ;

    private String code;
    private String info;
}
