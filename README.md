# 1.前言

基于通义千问大模型开发的 SDK，封装了常用的功能，如多模态对话、生成图像、图像编辑、生成视频等

# 2.引入方式

由于作者并未发布到公共仓库，需要手动将代码导入本地，之后 Maven install 到本地仓库，这里需要注意的是 SDK 所在仓库和需要导入 SDK 的项目的仓库需要统一，否则找不到

导入成功后，在项目的配置文件进行如下配置：

```java
# 通义千问配置
qwen:
  sdk:
    config:
      enable: true
      api-key: # apiKey 请自行到阿里云百炼平台申请
```

配置后即可直接使用：

```java
@Data
@ConfigurationProperties(prefix = "qwen.sdk.config", ignoreInvalidFields = true)
public class QwenConfigProperties {
    private boolean enable;
    private String apiKey;
}
```

```java
@Slf4j
@Configuration
@EnableConfigurationProperties(QwenConfigProperties.class)
public class QwenConfig {

    private final QwenConfigProperties properties;

    public QwenConfig(QwenConfigProperties properties) {
        this.properties = properties;
    }

    @Bean(name = "modelFactory")
    public ModelFactory modelFactory(QwenConfigProperties properties) {
        qwen.sdk.factory.Configuration configuration = new qwen.sdk.factory.Configuration(properties.getApiKey());
        log.info("通义千问配置完成");
        return new DefaultModelFactory(configuration);
    }

    @Bean(name = "chatService")
    @ConditionalOnProperty(value = "qwen.sdk.config.enable", havingValue = "true", matchIfMissing = false)
    public ChatServiceImpl chatService(ModelFactory modelFactory) {
        log.info("对话服务装配完成");
        return modelFactory.chatService();
    }

    @Bean(name = "imageService")
    @ConditionalOnProperty(value = "qwen.sdk.config.enable", havingValue = "true", matchIfMissing = false)
    public ImageServiceImpl imageService(ModelFactory modelFactory) {
        log.info("生成图像服务装配完成");
        return modelFactory.imageService();
    }

    @Bean(name = "videoService")
    @ConditionalOnProperty(value = "qwen.sdk.config.enable", havingValue = "true", matchIfMissing = false)
    public VideoServiceImpl videoService(ModelFactory modelFactory) {
        log.info("生成视频服务装配完成");
        return modelFactory.videoService();
    }
}
```

使用案例：

```java
public void testChat() throws IOException {
        List<ChatRequest.Input.Message> messages = new ArrayList<>();
        messages.add(ChatRequest.Input.Message.builder()
                .role("system")
                .content("You are a helpful assistant.")
                .build());
        messages.add(ChatRequest.Input.Message.builder()
                .role("user")
                .content("介绍《黑神话：悟空》")
                .build());
        ChatRequest request = ChatRequest.builder()
                .model("qwen-plus")
                .input(ChatRequest.Input.builder()
                        .messages(messages)
                        .build())
                .parameters(ChatRequest.Parameters.builder()
                                .resultFormat("message")
                                .enableSearch(true)
                                .searchOptions(ChatRequest.Parameters.SearchOptions.builder()
                                        .enableSource(true)
                                        .forcedSearch(true)
                                        .build())
                                .build())
                .build();
        ChatResponse response = chatServiceImpl.chat(request);
        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("返回结果:{}", JSON.toJSONString(response));
    }
```

