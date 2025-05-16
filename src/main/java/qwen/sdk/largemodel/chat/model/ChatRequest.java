package qwen.sdk.largemodel.chat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 对话请求体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {

    private String model;

    private Input input;

    private Parameters parameters;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Input {
        private List<Message> messages;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Message {
            private String role;
            private String content;
            private List<Content> contents;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Content {
                private String type;
                private String content;
                private int fps;
            }
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Parameters {
        private String resultFormat;
        private boolean incrementalOutput;
        private boolean enableSearch;
        private SearchOptions searchoptions;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class SearchOptions {
            private boolean enableSource;
            private boolean enableCitation;
            private String citationFormat;
            private boolean forcedSearch;
            private String searchStrategy;
        }
    }

}
