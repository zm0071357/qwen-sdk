package qwen.sdk.factory;

import qwen.sdk.largemodel.chat.impl.ChatServiceImpl;

public interface ModelFactory {
    ChatServiceImpl chatService();
}
