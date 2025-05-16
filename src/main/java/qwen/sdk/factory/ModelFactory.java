package qwen.sdk.factory;

import qwen.sdk.largemodel.chat.impl.ChatServiceImpl;
import qwen.sdk.largemodel.image.impl.ImageServiceImpl;

public interface ModelFactory {
    ChatServiceImpl chatService();
    ImageServiceImpl imageService();
}
