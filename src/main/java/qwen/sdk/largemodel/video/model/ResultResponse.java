package qwen.sdk.largemodel.video.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;


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
        private String video_url;

        private String code;
        private String message;
    }

    @Getter
    public static class Usage {
        private int video_duration;
        private String video_ratio;
        private int video_count;
    }

}
