package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MappingUtilsTest {

    static class Product {
        public String name;
        public double price;
        public String description;

        public Product() {}
        public Product(String name, double price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }
    }

    static class ProductResponse {
        public String name;
        public double price;

        public ProductResponse() {}
    }

    @Test
    void testMapping() {
        Product product = new Product("Laptop", 999.99, "A powerful laptop");
        ProductResponse response = MappingUtils.map(product, ProductResponse.class);

        assertNotNull(response);
        assertEquals("Laptop", response.name);
        assertEquals(999.99, response.price);
    }

    @Test
    void testListMapping() {
        java.util.List<Product> products = java.util.Arrays.asList(
            new Product("P1", 10, "D1"),
            new Product("P2", 20, "D2")
        );
        java.util.List<ProductResponse> responses = MappingUtils.mapList(products, ProductResponse.class);
        assertEquals(2, responses.size());
        assertEquals("P1", responses.get(0).name);
    }

    @Test
    void testMappingToJson() {
        Product product = new Product("Laptop", 999, "desc");
        String json = MappingUtils.toJson(product, ProductResponse.class);
        assertTrue(json.contains("\"name\":\"Laptop\""));
        assertFalse(json.contains("description"));
    }
}
