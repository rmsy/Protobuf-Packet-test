package com.github.rmsy;

import com.github.rmsy.handlers.TestMessageHandler;
import com.github.rmsy.protocol.PATestProto;
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
        registry.register(PATestProto.PlayerJoin.getDescriptor(), new TestMessageHandler());
        this.registry = registry;
    }

    public static void main(String[] args) {
        MessageHandlerRegistry registry = new SimpleMessageHandlerRegistry();
        new Main(registry);
        PacketManager<PATestProto.Packet> manager = new SimplePacketManager<>(PATestProto.Packet.newBuilder().setExtension(PATestProto.PlayerJoin.playerJoin, PATestProto.PlayerJoin.newBuilder().setName("iamramsey").setDisplayName("Isaac Moore").build()).build());
        System.out.println(manager.parse(registry));
    }
}
