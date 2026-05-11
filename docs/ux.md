# 🎨 UI & UX

Utilities for string manipulation, image processing, user agent parsing, and pagination.

---

## 🔤 StringUtils
Advanced string operations for slugs, masks, case conversions, and formatting.

### Key Methods
- `slugify(text)`: Convert to URL-friendly format (`"Hello World"` → `"hello-world"`).
- `toTitleCase(text)`: Capitalize each word.
- `toCamelCase(text)`: Convert to camelCase.
- `maskEmail(email)`: Mask email for display (`"a***@b***.com"`).
- `maskPhone(phone)`: Mask phone numbers.
- `truncate(text, length)`: Trim text with ellipsis.
- `replaceAccents(text)`: Remove diacritical marks.

### Usage Example
```java
String slug = StringUtils.slugify("Hello World! 2025"); // "hello-world-2025"
String title = StringUtils.toTitleCase("hello world"); // "Hello World"
String camel = StringUtils.toCamelCase("hello-world"); // "helloWorld"
String masked = StringUtils.maskEmail("user@example.com"); // "u***@e***.com"
```

---

## 🖼️ ImageUtils
Basic image processing using standard AWT.

### Key Methods
- `resize(inputPath, outputPath, width, height)`: Resize with aspect ratio.
- `toGrayscale(inputPath, outputPath)`: Convert to grayscale.
- `getImageDimensions(imagePath)`: Get width and height.
- `compressJpg(inputPath, outputPath, quality)`: Compress JPEG images.

### Usage Example
```java
ImageUtils.resize("/path/to/image.jpg", "/path/to/resized.jpg", 500, 300);
ImageUtils.toGrayscale("/path/to/color.jpg", "/path/to/gray.jpg");
```

---

## 🧑‍💼 UserAgentUtils
Parse and analyze HTTP User-Agent strings.

### Key Methods
- `getBrowser(userAgent)`: Extract browser name.
- `getOs(userAgent)`: Identify operating system.
- `getVersion(userAgent)`: Get browser version.
- `isMobile(userAgent)`: Detect mobile devices.
- `isBot(userAgent)`: Identify crawlers/bots.

### Usage Example
```java
String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64)...";
String browser = UserAgentUtils.getBrowser(userAgent); // "Chrome"
String os = UserAgentUtils.getOs(userAgent); // "Windows"
boolean isMobile = UserAgentUtils.isMobile(userAgent); // false
boolean isBot = UserAgentUtils.isBot(userAgent); // false
```

---

## 📋 ResourceUtils
Safe reading of files from inside the JAR classpath.

### Key Methods
- `readClasspathFile(path)`: Read file as String.
- `readClasspathFileAsStream(path)`: Get InputStream for resource files.

### Usage Example
```java
String config = ResourceUtils.readClasspathFile("application.properties");
InputStream stream = ResourceUtils.readClasspathFileAsStream("data.json");
```

---

## 🆔 IdUtils
Generate clean, readable IDs.

### Key Methods
- `generateUUID()`: Standard UUID v4.
- `generateShortId()`: Generate short alphanumeric IDs.
- `generateShortId(length)`: Custom length short IDs.
- `isValidUUID(id)`: Validate UUID format.

### Usage Example
```java
String uuid = IdUtils.generateUUID(); // "a3c1e8f2-7b4d-4e90..."
String shortId = IdUtils.generateShortId(); // "abc123xyz"
String customId = IdUtils.generateShortId(12); // "v4x9k2m8p1q5"
```

---

[⬅️ Back to Index](file:///d:/samp/bobsutils/docs/index.md)
