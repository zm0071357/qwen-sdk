package qwen.sdk.largemodel.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
        public static class Message<E> {
            private String role;

            private E content;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Content {
                private String image;
                private String text;
                private String audio;
            }
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Parameters {
        @JsonProperty("result_format")
        private String resultFormat;
        @JsonProperty("incremental_output")
        private boolean incrementalOutput;
        @JsonProperty("enable_search")
        private boolean enableSearch;
        @JsonProperty("search_options")
        private SearchOptions searchOptions;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class SearchOptions {
            @JsonProperty("enable_source")
            private boolean enableSource;
            @JsonProperty("enable_citation")
            private boolean enableCitation;
            @JsonProperty("citation_format")
            private String citationFormat;
            @JsonProperty("forced_search")
            private boolean forcedSearch;
            @JsonProperty("search_strategy")
            private String searchStrategy;
        }
    }

}
