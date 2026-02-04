package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testMainOutput() {
        Main.main(new String[]{});

        String expectedOutput =
                "Hello and welcome!" + System.lineSeparator() +
                        "i = 1" + System.lineSeparator() +
                        "i = 2" + System.lineSeparator() +
                        "i = 3" + System.lineSeparator() +
                        "i = 4" + System.lineSeparator() +
                        "i = 5" + System.lineSeparator() +
                        "hola" + System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }
}
