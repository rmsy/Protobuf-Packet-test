package com.github.rmsy;

import com.github.rmsy.handlers.TestMessageHandler;
import com.github.rmsy.protocol.TestProto;
import net.anxuiz.protobuf.packet.MessageHandlerRegistry;
import net.anxuiz.protobuf.packet.PacketManager;
import net.anxuiz.protobuf.packet.base.SimpleMessageHandlerRegistry;
import net.anxuiz.protobuf.packet.base.SimplePacketManager;

import javax.annotation.Nonnull;

/**
 * com.github.rmsy.Main class.
 */
public class Main {

    private final MessageHandlerRegistry registry;

    private Main(@Nonnull MessageHandlerRegistry registry) {
        registry.register(TestProto.ExtendingMessage.getDescriptor(), new TestMessageHandler());
        this.registry = registry;
    }

    public static void main(String[] args) {
        MessageHandlerRegistry registry = new SimpleMessageHandlerRegistry();
        new Main(registry);
        PacketManager<TestProto.DefaultMessage> manager = new SimplePacketManager<>(TestProto.DefaultMessage.newBuilder().setExtension(TestProto.ExtendingMessage.msg, TestProto.OtherMessage.newBuilder().build()).build());
        System.out.println(manager.parse(registry));
    }
}
