# BobsUtils 🛠️ [![](https://jitpack.io/v/ro35ert/bobsutils.svg)](https://jitpack.io/#ro35ert/bobsutils)

A premium, lightweight Java utility library designed for universal use and maximum productivity. Featuring **32 specialized modules**.

## ✨ Modules

### Data & Transformation
- **JsonUtils**: Simplified JSON serialization/deserialization.
- **CsvUtils**: Lightweight CSV parsing and generation (handling escapes).
- **XmlUtils**: Basic W3C XML parsing and tag value retrieval.
- **MappingUtils**: Powerful generic object-to-object mapping (Entities ⇋ DTOs).
- **UnitConverterUtils**: Convert between Metric and Imperial units (Temp, Weight, etc.).
- **ImageUtils**: Basic image processing (Resize, Grayscale) using standard AWT.

### Communication & Marketing
- **EmailUtils**: Multi-provider support: **SMTP, Brevo, Mailgun, SendGrid, SparkPost**.
- **QrCodeUtils**: Highly customizable QR generation (Colors, Size, PNG, Base64).
- **PhoneUtils**: Specialized normalization for **Zambian networks (+260)**.

### Core & Productivity
- **StringUtils**: 20+ methods for slugifying, masking, case-conversion, etc.
- **NumberUtils**: Safe parsing, currency formatting, and Roman numerals.
- **DateUtils**: Auto-parsing of strings (including JS dates) and semantic naming.
- **CollectionUtils**: Safe access, shuffling, and partitioning.
- **ValidationUtils**: Centralized assertions (`isUrl`, `isEmail`) and password checks.
- **StopWatch**: Simple performance measurement and execution timing.
- **IdUtils**: Clean UUID and Short ID generation.

### Systems & Operations
- **FileUtils**: Extension extraction and human-readable size conversion.
- **ResourceUtils**: Safe reading of files from inside the JAR classpath.
- **CompressionUtils**: One-line Zip and Unzip operations.
- **PropertiesUtils**: Simplified loading and saving of `.properties` files.
- **SystemUtils**: Env variable access and OS identification.
- **NetworkUtils**: URL reachability checks and query parameter parsing.

### Specialized Math & Logic
- **MoneyUtils**: High-precision financial calculations using `BigDecimal`.
- **GeoUtils**: GPS distance calculations using the **Haversine formula**.
- **PaginationUtils**: Calculating database offsets and total pages.

### Security & Reliability
- **SanitizationUtils**: Multi-layer cleaning for HTML, SQL, and filenames.
- **SecurityUtils**: One-line hashing (SHA-256, MD5) and secure tokens.
- **EncryptionUtils**: Two-way symmetric **AES-256 encryption** and decryption.
- **RetryUtils**: Functional wrapper for fault-tolerant retries with backoff.
- **ReflectionUtils**: Safe access to private fields and property manipulation.

## 🚀 Usage Examples

### Resize Image
```java
byte[] thumbnail = ImageUtils.resize(originalBytes, 100, 100, "PNG");
```

### CSV Parsing
```java
List<String[]> data = CsvUtils.parse("Name,Age\nBob,30");
```

## 📄 License
MIT License.
