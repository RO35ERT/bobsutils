# 📊 Data & Transformation

Utilities for JSON, CSV, XML, and complex data structures.

---

## 🗄️ JsonUtils
High-performance JSON serialization and deserialization using Jackson.

### Key Methods
- `toJson(object)`: Convert POJO to String.
- `fromJson(json, Class)`: Convert String to POJO (returns `Optional`).
- `getMapper()`: Access the pre-configured `ObjectMapper`.

### 💡 Advanced Pattern: JSON Flattening
If you have a nested JSON structure but want to keep your POJO flat, you can use the following pattern:

```java
public class UserResponse {
    private String userId;

    @JsonProperty("user")
    private void unpackUser(User user) {
        this.userId = user != null ? user.getId() : null;
    }
}
```
*This allows you to extract specific fields from a nested object during deserialization.*

---

## 📄 CsvUtils
Parsing and building CSV data with proper escaping.

### Key Methods
- `parse(csvString)`: Returns `List<String[]>`.
- `build(rows)`: Generates a CSV string from a list of string arrays.

---

## 🗺️ MappingUtils
Simplified object-to-object mapping (e.g., Entity to DTO).

### Usage Example
```java
UserDTO dto = MappingUtils.toResponse(userEntity, UserDTO.class);
```

---

## 📦 CollectionUtils
Advanced operations on Java Collections.

### Key Methods
- `partition(list, size)`: Split a list into smaller chunks.
- `isNullOrEmpty(collection)`: Safe null check.
- `distinctBy(list, selector)`: Filter unique items by a property.

---

## 🔒 CompressionUtils
GZIP and ZIP utilities for handling compressed data.

---

[⬅️ Back to Index](file:///d:/samp/bobsutils/docs/index.md)
