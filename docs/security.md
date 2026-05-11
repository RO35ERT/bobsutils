# 🔒 Security & Reliability

Utilities for protecting data and ensuring system stability.

---

## 🔑 EncryptionUtils
Standardized AES-256 encryption for sensitive data.

### Usage Example
```java
String encrypted = EncryptionUtils.encrypt("secret message", "my-key-123");
String decrypted = EncryptionUtils.decrypt(encrypted, "my-key-123");
```

---

## 🧹 SanitizationUtils
Clean and safe input handling.

### Key Methods
- `stripHtml(html)`: Removes all HTML tags (uses Jsoup).
- `sanitizeFilename(name)`: Removes characters that could lead to directory traversal.

---

## 🔄 RetryUtils
Fault-tolerance for flaky operations (e.g., network calls).

### Usage Example
```java
String result = RetryUtils.retry(() -> {
    return apiCall();
}, 3, 1000); // 3 attempts, 1s delay
```

---

## 🛡️ SecurityUtils
Hashing and token generation.

### Key Methods
- `hashPassword(plain)`: Generate a secure bcrypt hash.
- `verifyPassword(plain, hash)`: Check a password.
- `generateToken(length)`: Create secure random strings.

---

## ✅ ValidationUtils
Fluent API for input validation.

### Usage Example
```java
ValidationUtils.validate(email)
    .isNotEmpty("Email is required")
    .isEmail("Invalid email format")
    .throwIfInvalid();
```

---

[⬅️ Back to Index](file:///d:/samp/bobsutils/docs/index.md)
