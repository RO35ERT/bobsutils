# BobsUtils Documentation 📖

Welcome to the official documentation for **BobsUtils**, a premium Java utility library.

## 📌 Integration
Add the library to your project:
```xml
<dependency>
  <groupId>com.tumbwe</groupId>
  <artifactId>bobsutils</artifactId>
  <version>1.0.0</version>
</dependency>
```

---

## 🛠️ Module Guide

### 📱 Communication & Marketing
#### QrCodeUtils
Generate barcodes for your web apps instantly.
- `generateBase64(text, size)`: Returns a data URI for `<img>` tags.
- `generatePng(text, size, foreground, background)`: Custom colored files.

#### EmailUtils
One interface, 5 providers.
- `sendBrevo(apiKey, from, to, subject, html)`
- `sendSendGrid(...)`, `sendMailgun(...)`, `sendSmtp(...)`, etc.

#### PhoneUtils
- `normalizeZambian(phone)`: Converts `097...` to `26097...`
- `getZambianNetwork(phone)`: Returns `AIRTEL`, `MTN`, etc.

### 📊 Data & Transformation
#### MappingUtils
Map between DTOs and Entities with zero boilerplate.
- `toResponse(entity, Class)`: Semantic mapping for API responses.
- `toModel(dto, Class)`: Semantic mapping for DB entities.

#### CsvUtils
- `parse(csvString)`: Returns `List<String[]>`.
- `build(rows)`: Generates valid CSV strings with escaping.

#### UnitConverterUtils
- `celsiusToFahrenheit(c)` / `kgToLbs(kg)` / `metersToFeet(m)`

### 🔒 Security & Reliability
#### EncryptionUtils
- `encrypt(data, key)` / `decrypt(data, key)`: Using AES-256.

#### SanitizationUtils
- `stripHtml(html)`: Clean input using Jsoup.
- `sanitizeFilename(name)`: Prevents directory traversal.

#### RetryUtils
- `retry(() -> job(), attempts, delay)`: Fault-tolerance.

### ⚙️ Systems & Logic
#### FileUtils
- `humanReadableSize(bytes)`: Converts `1048576` to `1.0 MB`.
- `getExtension(filename)`: Standard extraction logic.

#### StopWatch
- Accurate performance measuring for profiling code blocks.

---

## 🧪 Quick Reference Table

| Module | Purpose | Key Method |
| :--- | :--- | :--- |
| **StringUtils** | Text manipulation | `slugify()` |
| **NumberUtils** | Math & Formats | `formatCurrency()` |
| **DateUtils** | Parsing & Times | `toFriendlyDate()` |
| **CollectionUtils** | List handling | `partition()` |
| **GeoUtils** | GPS Math | `calculateDistance()` |
| **IdUtils** | Identity | `shortId()` |

---

## 📜 License
This project is licensed under the MIT License.
