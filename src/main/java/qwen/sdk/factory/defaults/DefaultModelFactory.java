package qwen.sdk.factory.defaults;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import qwen.sdk.factory.Configuration;
import qwen.sdk.factory.ModelFactory;
import qwen.sdk.largemodel.chat.ChatService;
import qwen.sdk.largemodel.chat.impl.ChatServiceImpl;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

public class DefaultModelFactory implements ModelFactory {

    private final Configuration configuration;

    private final OkHttpClient httpClient;

    public DefaultModelFactory(Configuration configuration) {
        this.configuration = configuration;
        // 日志配置
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(configuration.getLevel());
        // 开启HTTP客户端
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(configuration.getConnectTimeOut(), TimeUnit.SECONDS)
                .writeTimeout(configuration.getWriteTimeOut(), TimeUnit.SECONDS)
                .readTimeout(configuration.getReadTimeOut(), TimeUnit.SECONDS)
                .build();
    }

    @Override
    public ChatServiceImpl chatService() {
        ChatService chatService = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(ChatService.class);
        return new ChatServiceImpl(chatService, configuration);
    }
}
