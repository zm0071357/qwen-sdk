package qwen.sdk.factory;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSources;

/**
 * 配置类
 */
@Data
@Getter
public class Configuration {

    @Setter
    private String apiHost = "https://dashscope.aliyuncs.com";

    private final String apiKey;

    @Setter
    private OkHttpClient okHttpClient;
    @Setter
    private HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.HEADERS;
    @Setter
    private long connectTimeOut = 60;
    @Setter
    private long writeTimeOut = 60;
    @Setter
    private long readTimeOut = 60;

    public String getAuthorization() {
        return "Bearer " + apiKey;
    }

    public EventSource.Factory createRequestFactory() {
        return EventSources.createFactory(okHttpClient);
    }
}
