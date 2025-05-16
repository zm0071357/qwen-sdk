package qwen.sdk.largemodel.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

/**
 * 对话响应体
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatResponse {
    private int status_code;
    private String request_id;
    private String code;
    private String message;
    private Output output;
    private Usage usage;

    @Getter
    public static class Output {
        private String text;
        private String finish_reason;
        private List<Choices> choices;

        @Getter
        public static class Choices {
            private String finish_reason;
            private Message message;

            @Getter
            public static class Message {
                private String role;
                private String content;
            }
        }
    }

    @Getter
    public static class Usage {
        private int input_tokens;
        private int output_tokens;
        private int total_tokens;
        private int image_tokens;
        private int video_tokens;
        private int audio_tokens;
        private Object prompt_tokens_details;
    }
}
