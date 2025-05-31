package qwen.sdk.largemodel.image.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

/**
 * 图像任务响应体
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultResponse {
    private String request_id;
    private OutPut output;
    private Usage usage;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OutPut {
        private String task_id;
        private String task_status;
        private String submit_time;
        private String scheduled_time;
        private String end_time;
        private List<Results> results;
        private TaskMetrics task_metrics;

        @Getter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Results {
            private String orig_prompt;
            private String actual_prompt;
            private String url;
            private String code;
            private String message;
        }

        @Getter
        public static class TaskMetrics {
            private int TOTAL;
            private int SUCCEEDED;
            private int FAILED;
        }
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Usage {
        private int image_count;
    }

}
