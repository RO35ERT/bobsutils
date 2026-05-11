# BobsUtils Documentation 📖

Welcome to the comprehensive documentation for **BobsUtils**, a premium Java utility library designed for performance, reliability, and ease of use.

## 📦 Version Information

| Component | Version | Notes |
| :--- | :--- | :--- |
| **BobsUtils Library** | `1.0.0` | Current Release |
| Java Compatibility | `17+` | Requires Java 17 or higher |
| Jackson (JSON) | `2.16.1` | Advanced serialization |
| Lombok | `1.18.30` | Boilerplate reduction |
| JUnit 5 | `5.10.1` | Testing framework |
| Build Status | Active | Open source on GitHub |
| License | MIT | Free for commercial use |

---

## 📑 Documentation Index

### 🚀 **[Complete Usage Guide](USAGE.md)** ← START HERE
Comprehensive guide with real-world scenarios and code examples for all utilities!

---

## 🗺️ Category Navigation

Select a category below to explore specific utilities:

### 📱 [Communication & Marketing](communication.md)
Email (Brevo, SendGrid, SMTP), QR Code generation, and Zambian phone number normalization.

### 📊 [Data & Transformation](data.md)
JSON handling, CSV parsing, XML utilities, DTO mapping, collection helpers, and **@JsonProperty pattern** for nested JSON flattening.

### 🔒 [Security & Reliability](security.md)
AES encryption, HTML sanitization, retry logic, input validation, and secure token generation.

### ⚙️ [Systems & Logic](systems.md)
File management, system properties, network checks, reflection utilities, and performance monitoring.

### 🔢 [Math & Formats](math.md)
Number formatting, Money handling, Date/Time parsing, Unit conversion, Geo calculations, and Pagination.

### 🎨 [UI & UX](ux.md)
String manipulation (slugs, cases), Image processing, UserAgent parsing, ID generation, and Pagination helpers.

---

## 🎯 Quick Navigation by Use Case

**What are you trying to do?**

- **Send emails** → [📱 Communication](communication.md#-emailutils)
- **Parse/generate JSON** → [📊 Data](data.md#-jsonutils)
- **Flatten nested JSON** → [📊 Data](data.md#-advanced-pattern-json-flattening)
- **Encrypt sensitive data** → [🔒 Security](security.md#-encryptionutils)
- **Validate user input** → [🔒 Security](security.md#-validationutils)
- **Work with files** → [⚙️ Systems](systems.md#-fileutils)
- **Convert units** → [🔢 Math](math.md#-unitconverterutils)
- **Generate slugs** → [🎨 UI/UX](ux.md#-stringutils)
- **Measure performance** → [⚙️ Systems](systems.md#-stopwatch)
- **Handle pagination** → [🔢 Math](math.md#-paginationutils)
- **Work with Zambian phone numbers** → [📱 Communication](communication.md#-phoneutils)
- **Generate QR codes** → [📱 Communication](communication.md#-qrcodeutils)

---

## 🚀 Quick Start

### Maven
```xml
<dependency>
  <groupId>com.tumbwe</groupId>
  <artifactId>bobsutils</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Gradle
```gradle
implementation 'com.tumbwe:bobsutils:1.0.0'
```

### JitPack (GitHub-based)
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
