package qwen.sdk.largemodel.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

/**
 * 多模态对话响应体
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMutiResponse {
    private int status_code;
    private String request_id;
    private String code;
    private String message;
    private Output output;
    private Usage usage;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Output {
        private String text;
        private String finish_reason;
        private List<Choices> choices;
        private SearchInfo search_info;

        @Getter
        public static class Choices {
            private String finish_reason;
            private Message message;

            @Getter
            public static class Message {
                private String role;
                private List<Text> content;

                @Getter
                public static class Text {
                    private String text;
                }
            }
        }

        @Getter
        public static class SearchInfo {
            List<SearchResults> search_results;

            @Getter
            public static class SearchResults {
                public String site_name;
                public String icon;
                public int index;
                public String title;
                public String url;
            }
        }
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
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
