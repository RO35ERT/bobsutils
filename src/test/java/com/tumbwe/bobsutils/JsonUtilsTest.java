package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class JsonUtilsTest {

    static class TimeModel {
        public String name;
        public LocalDateTime timestamp;

        public TimeModel() {}
        public TimeModel(String name, LocalDateTime timestamp) {
            this.name = name;
            this.timestamp = timestamp;
        }
    }

    @Test
    void testJsonWithTime() {
        LocalDateTime now = LocalDateTime.now();
        TimeModel model = new TimeModel("Test", now);
        
        String json = JsonUtils.toJson(model);
        assertNotNull(json);
        
        Optional<TimeModel> decoded = JsonUtils.fromJson(json, TimeModel.class);
        assertTrue(decoded.isPresent());
        assertEquals("Test", decoded.get().name);
        // Compare string versions or truncated nanos if there are precision issues
        assertEquals(now.toString().substring(0, 19), decoded.get().timestamp.toString().substring(0, 19));
    }
}
