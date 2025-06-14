package qwen.sdk.largemodel.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMutiStreamResponse {
    private String request_id;
    private Output output;
    private Usage usage;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Output {
        private List<Choices> choices;

        @Getter
        @Setter
        public static class Choices {
            private String finish_reason;
            private Message message;

            @Getter
            @Setter
            public static class Message {
                private String role;
                private List<Text> content;

                @Getter
                @Setter
                public static class Text {
                    private String text;
                }
            }
        }

    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Usage {
        private Integer total_tokens;
        private Integer output_tokens;
        private Integer input_tokens;
    }
}
