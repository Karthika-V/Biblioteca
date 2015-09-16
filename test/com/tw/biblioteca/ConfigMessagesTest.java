package com.tw.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ConfigMessagesTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldDisplayConfigMessages() {
        ConfigMessages configMessages = new ConfigMessages();
        configMessages.displayMessage("Any Message");

        assertEquals("Any Message\n",outContent.toString());
    }

}