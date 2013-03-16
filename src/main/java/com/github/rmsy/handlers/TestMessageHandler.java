package com.github.rmsy.handlers;

import com.google.protobuf.Message;
import net.anxuiz.protobuf.packet.HandlerException;
import net.anxuiz.protobuf.packet.MessageHandler;

import javax.annotation.Nonnull;

/**
 * File created at: 3/16/13 4:09 PM
 */
public class TestMessageHandler implements MessageHandler {
    @Override
    public void handle(@Nonnull final Message message) throws HandlerException {
        try {
            System.out.println(message.toString());
        } catch (Exception e) {
            throw new HandlerException(e.getCause());
        }
    }
}
