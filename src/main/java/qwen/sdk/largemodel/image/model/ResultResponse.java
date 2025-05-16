package qwen.sdk.largemodel.image.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultResponse {
    private String request_id;
    private OutPut output;
    private Usage usage;

    @Getter
    public static class OutPut {
        private String task_id;
        private String task_status;
        private String submit_time;
        private String scheduled_time;
        private String end_time;
        private List<Results> results;
        private TaskMetrics task_metrics;

        @Getter
        public static class Results {
            private String orig_prompt;
            private String actual_prompt;
            private String url;
            private String code;
            private String message;
        }

        @Getter
        public static class TaskMetrics {
            @JsonProperty("TOTAL")
            private int TOTAL;
            @JsonProperty("SUCCEEDED")
            private int SUCCEEDED;
            @JsonProperty("FAILED")
            private int FAILED;
        }
    }

    @Getter
    public static class Usage {
        private int image_count;
    }

}
