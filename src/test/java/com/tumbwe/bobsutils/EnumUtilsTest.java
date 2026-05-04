package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class EnumUtilsTest {

    enum TestEnum {
        VAL1, VAL2
    }

    @Test
    void testGetEnum() {
        Optional<TestEnum> result = EnumUtils.getEnum(TestEnum.class, "VAL1");
        assertTrue(result.isPresent());
        assertEquals(TestEnum.VAL1, result.get());

        assertTrue(EnumUtils.getEnum(TestEnum.class, "INVALID").isEmpty());
        assertTrue(EnumUtils.getEnum(TestEnum.class, null).isEmpty());
        assertTrue(EnumUtils.getEnum(null, "VAL1").isEmpty());
    }

    @Test
    void testIsValid() {
        assertTrue(EnumUtils.isValid(TestEnum.class, "VAL1"));
        assertTrue(EnumUtils.isValid(TestEnum.class, "  VAL2  "));
        assertFalse(EnumUtils.isValid(TestEnum.class, "VAL3"));
        assertFalse(EnumUtils.isValid(TestEnum.class, null));
    }
}
