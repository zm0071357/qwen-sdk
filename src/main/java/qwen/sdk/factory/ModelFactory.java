package qwen.sdk.factory;

import qwen.sdk.largemodel.chat.impl.ChatServiceImpl;
import qwen.sdk.largemodel.image.impl.ImageServiceImpl;
import qwen.sdk.largemodel.video.impl.VideoServiceImpl;

public interface ModelFactory {
    ChatServiceImpl chatService();
    ImageServiceImpl imageService();
    VideoServiceImpl videoService();
}
