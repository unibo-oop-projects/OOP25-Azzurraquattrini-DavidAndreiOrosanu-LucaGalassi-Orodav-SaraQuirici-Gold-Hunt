package it.unibo.goldhunt.configuration.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;
import org.junit.jupiter.api.Test;

class EasyConfigTest {

    private EasyConfig config;

    @BeforeEach
    void setup() {
        config = new EasyConfig();
    }

    @Test
    void testBoardSize() {
        assertEquals(9, config.getBoardSize());
    }

    @Test
    void testTrapCount() {
        assertEquals(10, config.getTrapCount());
    }

    @Test 
    void testItemConfigNotNull() {
        assertNotNull(config.getItemConfig());
    }

    @Test
    void testItemQuantities() {
        Map<String, Integer> items = config.getItemConfig();
        assertEquals(2, items.get("D"));
        assertEquals(5, items.get("G"));
        assertEquals(1, items.get("X"));
        assertEquals(3, items.get("L"));
        assertEquals(1, items.get("C"));
        assertEquals(0, items.get("M"));
        assertEquals(1, items.get("P"));
        assertEquals(1, items.get("S"));
    }
}
