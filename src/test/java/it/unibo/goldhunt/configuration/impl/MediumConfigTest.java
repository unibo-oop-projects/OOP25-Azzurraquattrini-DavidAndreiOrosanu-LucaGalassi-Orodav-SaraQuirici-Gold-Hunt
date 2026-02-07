package it.unibo.goldhunt.configuration.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MediumConfigTest {

    private MediumConfig config;

    @BeforeEach
    void setup() {
        config = new MediumConfig();
    }

    @Test
    void testBoardSize() {
        assertEquals(16, config.getBoardSize());
    }

    @Test
    void testTrapCount() {
        assertEquals(40, config.getTrapCount());
    }

    @Test 
    void testItemConfigNotNull() {
        assertNotNull(config.getItemConfig());
    }

    @Test
    void testItemQuantities() {
        Map<String, Integer> items = config.getItemConfig();
        assertEquals(3, items.get("D"));
        assertEquals(12, items.get("G"));
        assertEquals(2, items.get("X"));
        assertEquals(4, items.get("L"));
        assertEquals(1, items.get("C"));
        assertEquals(2, items.get("M"));
        assertEquals(2, items.get("P"));
        assertEquals(2, items.get("S"));
    }
}