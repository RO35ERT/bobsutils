# ⚙️ Systems & Logic

Low-level utilities for interacting with the file system, network, and JVM.

---

## 📂 FileUtils
Efficient file and directory operations.

### Key Methods
- `humanReadableSize(bytes)`: Converts bytes to `KB`, `MB`, etc.
- `getExtension(filename)`: Returns the file extension.
- `writeString(path, content)`: Simplified write operation.

---

## ⏱️ StopWatch
Precise performance measuring.

### Usage Example
```java
StopWatch sw = StopWatch.start();
// ... run code ...
long elapsed = sw.stop().getElapsedMillis();
System.out.println("Execution took: " + elapsed + "ms");
```

---

## 🌐 NetworkUtils
Check connectivity and resolve IP addresses.

### Key Methods
- `isReachable(host, timeout)`: Pings a host.
- `getExternalIp()`: Fetches the public IP of the current machine.

---

## 🏗️ ReflectionUtils
Simplifies Java Reflection for dynamic object access.

### Key Methods
- `getFieldValue(obj, name)`
- `invokeMethod(obj, name, args)`

---

## 📋 PropertiesUtils
Load and manage `.properties` files with ease.

---

[⬅️ Back to Index](file:///d:/samp/bobsutils/docs/index.md)
