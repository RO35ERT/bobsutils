# 📖 Complete Usage Guide

A comprehensive guide on how to use BobsUtils utilities in real-world scenarios.

---

## 🚀 Getting Started

### Installation

**Maven:**
```xml
<dependency>
  <groupId>com.tumbwe</groupId>
  <artifactId>bobsutils</artifactId>
  <version>1.0.0</version>
</dependency>
```

**Gradle:**
```gradle
implementation 'com.tumbwe:bobsutils:1.0.0'
```

**JitPack:**
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>

<dependency>
  <groupId>com.github.ro35ert</groupId>
  <artifactId>bobsutils</artifactId>
  <version>1.0.0</version>
</dependency>
```

---

## 📚 Usage Scenarios

### 1️⃣ REST API Response Handling

**Scenario:** You're calling a third-party API that returns nested JSON, but you want to flatten it into your domain model.

```java
import com.tumbwe.bobsutils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
    private String userId;
    private String email;

    @JsonProperty("user")
    private void unpackUser(User user) {
        // Extract userId from nested user object during deserialization
        this.userId = user != null ? user.getId() : null;
    }
}

// Usage:
String apiResponse = """
{
    "email": "john@example.com",
    "user": {"id": "123", "name": "John"}
}
""";

UserResponse response = JsonUtils.fromJson(apiResponse, UserResponse.class)
    .orElseThrow(() -> new RuntimeException("Failed to parse"));
```

---

### 2️⃣ Email Sending Across Multiple Providers

**Scenario:** Your application needs to send emails, but the provider choice is configurable.

```java
import com.tumbwe.bobsutils.EmailUtils;

String from = "noreply@company.com";
String to = "user@example.com";
String subject = "Welcome!";
String htmlContent = "<h1>Welcome to Our Platform</h1>";

// SMTP
EmailUtils.sendSmtp("smtp.gmail.com", 587, "user", "password", from, to, subject, htmlContent);

// Or SendGrid
EmailUtils.sendSendGrid("sg_api_key_here", from, to, subject, htmlContent);

// Or Brevo
EmailUtils.sendBrevo("brevo_api_key", from, to, subject, htmlContent);
```

---

### 3️⃣ Data Export to CSV

**Scenario:** Export a list of users to CSV format.

```java
import com.tumbwe.bobsutils.CsvUtils;
import com.tumbwe.bobsutils.CollectionUtils;
import java.util.List;

List<User> users = userRepository.findAll();

// Build CSV rows
List<String[]> rows = new ArrayList<>();
rows.add(new String[]{"ID", "Name", "Email"}); // Header

users.forEach(user -> 
    rows.add(new String[]{user.getId(), user.getName(), user.getEmail()})
);

String csv = CsvUtils.build(rows);
// Save to file or send as download
```

---

### 4️⃣ Secure Data Encryption

**Scenario:** Store sensitive customer data securely in database.

```java
import com.tumbwe.bobsutils.EncryptionUtils;
import com.tumbwe.bobsutils.SecurityUtils;

// Generate a secure key once and store it securely
String encryptionKey = "my-secret-key-must-be-32-chars!"; // or load from env

// Encrypt sensitive data before storing
String ssn = "123-45-6789";
String encrypted = EncryptionUtils.encrypt(ssn, encryptionKey);
database.save(encrypted);

// Decrypt when needed
String decrypted = EncryptionUtils.decrypt(encrypted, encryptionKey); // "123-45-6789"

// Hash passwords (one-way)
String passwordHash = SecurityUtils.hashPassword("user_password");
database.save(passwordHash);

// Later, verify password on login
boolean isCorrect = SecurityUtils.verifyPassword("user_password", passwordHash);
```

---

### 5️⃣ Zambian Mobile Number Validation

**Scenario:** Validate and normalize Zambian phone numbers from user input.

```java
import com.tumbwe.bobsutils.PhoneUtils;
import com.tumbwe.bobsutils.ValidationUtils;

String userInput = "0977123456"; // Various formats possible
String normalizedPhone = PhoneUtils.normalizeZambian(userInput);

if (PhoneUtils.isValidZambian(normalizedPhone)) {
    PhoneUtils.Network network = PhoneUtils.getZambianNetwork(normalizedPhone);
    if (network == PhoneUtils.Network.AIRTEL) {
        // Send to Airtel-specific api
    }
}
```

---

### 6️⃣ High-Performance JSON Mapping

**Scenario:** Map database entities to API DTOs efficiently.

```java
import com.tumbwe.bobsutils.MappingUtils;

// Entity from database
UserEntity entity = userRepository.findById(123);

// Map to DTO for API response
UserDTO dto = MappingUtils.toResponse(entity, UserDTO.class);
```

---

### 7️⃣ Retry Logic for Flaky APIs

**Scenario:** Call an unreliable external API with automatic retry.

```java
import com.tumbwe.bobsutils.RetryUtils;

String result = RetryUtils.retry(
    () -> externalApi.fetchData(), // Supplier
    3,      // Max attempts
    1000    // Delay between attempts (ms)
);
```

---

### 8️⃣ Paginated Data Retrieval

**Scenario:** Implement pagination for a large dataset.

```java
import com.tumbwe.bobsutils.PaginationUtils;

int pageNumber = request.getPageNumber(); // 1, 2, 3...
int pageSize = 20;

int offset = PaginationUtils.getOffset(pageNumber, pageSize);
List<User> page = userRepository.findAll(offset, pageSize);

int totalUsers = userRepository.count();
int totalPages = PaginationUtils.getTotalPages(totalUsers, pageSize);

response.setData(page);
response.setTotalPages(totalPages);
```

---

### 9️⃣ QR Code Generation for Mobile Apps

**Scenario:** Generate a QR code for two-factor authentication.

```java
import com.tumbwe.bobsutils.QrCodeUtils;

String totp2faUrl = "otpauth://totp/MyApp:user@example.com?secret=JBSWY3DPEBLW64TMMQ======";

// Generate as Base64 data URI (embed in <img src="...">)
String base64DataUri = QrCodeUtils.generateBase64(totp2faUrl, 300);

// Or generate custom colors
String customQr = QrCodeUtils.generatePng(totp2faUrl, 300, 0x000000, 0xFFFFFF);
```

---

### 🔟 Input Validation & Sanitization

**Scenario:** Validate and clean user input from form submissions.

```java
import com.tumbwe.bobsutils.ValidationUtils;
import com.tumbwe.bobsutils.SanitizationUtils;

// Fluent validation
ValidationUtils.validate(email)
    .isNotEmpty("Email is required")
    .isEmail("Invalid email format")
    .throwIfInvalid();

// Sanitize HTML input (prevent XSS)
String userSubmittedHtml = request.getParameter("bio");
String sanitized = SanitizationUtils.stripHtml(userSubmittedHtml);

// Clean filenames (prevent directory traversal)
String userFilename = "../../etc/passwd"; // dangerous!
String safe = SanitizationUtils.sanitizeFilename(userFilename);
```

---

### 1️⃣1️⃣ URL-Friendly Slugs for Blog Posts

**Scenario:** Convert article titles to URL slugs.

```java
import com.tumbwe.bobsutils.StringUtils;

String articleTitle = "Hello World! 2025 🎉";
String slug = StringUtils.slugify(articleTitle); // "hello-world-2025"

String url = "/blog/" + slug; // /blog/hello-world-2025
```

---

### 1️⃣2️⃣ Performance Monitoring

**Scenario:** Measure execution time of critical operations.

```java
import com.tumbwe.bobsutils.StopWatch;

StopWatch timer = StopWatch.start();

// ... run expensive operation ...
List<User> users = dbQuery.execute();

long milliseconds = timer.stop().getElapsedMillis();
logger.info("Query took {} ms", milliseconds);
```

---

### 1️⃣3️⃣ Batch Processing with Partitioning

**Scenario:** Process a large list in smaller batches (e.g., for bulk email).

```java
import com.tumbwe.bobsutils.CollectionUtils;

List<User> allUsers = userRepository.findAll();
int batchSize = 100;

List<List<User>> batches = CollectionUtils.partition(allUsers, batchSize);

batches.forEach(batch -> {
    sendBulkEmail(batch); // Process each batch
});
```

---

### 1️⃣4️⃣ Distance Calculations

**Scenario:** Find all stores within a 50km radius of the user.

```java
import com.tumbwe.bobsutils.GeoUtils;

double userLat = -15.387;
double userLon = 28.322; // Lusaka

List<Store> nearbyStores = storeRepository.findAll()
    .stream()
    .filter(store -> GeoUtils.isWithinRadius(
        userLat, userLon,
        store.getLatitude(), store.getLongitude(),
        50.0 // 50km radius
    ))
    .collect(Collectors.toList());
```

---

### 1️⃣5️⃣ Unit Conversions in E-Commerce

**Scenario:** Convert product weights/temperatures based on user location.

```java
import com.tumbwe.bobsutils.UnitConverterUtils;

// US customer sees pounds, storage shows kg
double weightKg = 2.5;
double weightLbs = UnitConverterUtils.kilogramsToPounds(weightKg); // 5.51

// Temperature conversions for recipe app
double tempCelsius = 180.0;
double tempFahrenheit = UnitConverterUtils.celsiusToFahrenheit(tempCelsius); // 356
```

---

## 📖 Documentation Structure

**Quick navigation to detailed documentation:**

- 📱 [Communication & Marketing](communication.md)
- 📊 [Data & Transformation](data.md) *← @JsonProperty example here*
- 🔒 [Security & Reliability](security.md)
- ⚙️ [Systems & Logic](systems.md)
- 🔢 [Math & Formats](math.md)
- 🎨 [UI & UX](ux.md)

---

## 🔧 Version Information

| Component | Version |
|-----------|---------|
| BobsUtils | 1.0.0 |
| Java | 17+ |
| Jackson | 2.16.1 |
| Lombok | 1.18.30 |
| JUnit 5 | 5.10.1 |

---

## 🤝 Contributing
Issues and pull requests welcome on [GitHub](https://github.com/ro35ert/bobsutils)

## 📄 License
MIT License - See LICENSE file for details
