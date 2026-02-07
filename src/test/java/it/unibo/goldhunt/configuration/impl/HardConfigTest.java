package it.unibo.goldhunt.configuration.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;
import org.junit.jupiter.api.Test;

class HardConfigTest {

    private HardConfig config;

    @BeforeEach
    void setup() {
        config = new HardConfig();
    }

    @Test
    void testBoardSize() {
        assertEquals(22, config.getBoardSize());
    }

    @Test
    void testTrapCount() {
        assertEquals(99, config.getTrapCount());
    }

    @Test 
    void testItemConfigNotNull() {
        assertNotNull(config.getItemConfig());
    }

    @Test
    void testItemQuantities() {
        Map<String, Integer> items = config.getItemConfig();
        assertEquals(4, items.get("D"));
        assertEquals(24, items.get("G"));
        assertEquals(4, items.get("X"));
        assertEquals(5, items.get("L"));
        assertEquals(1, items.get("C"));
        assertEquals(3, items.get("M"));
        assertEquals(3, items.get("P"));
        assertEquals(3, items.get("S"));
    }
}