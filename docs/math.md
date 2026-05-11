# 🔢 Math & Formats

Utilities for handling numeric calculations, date/time parsing, unit conversions, and financial operations.

---

## 💰 MoneyUtils
High-precision financial calculations using `BigDecimal`.

### Key Methods
- `formatCurrency(amount, locale)`: Format money values.
- `add(amount1, amount2)`: Safe addition.
- `multiply(amount, multiplier)`: Safe multiplication.
- `round(amount, decimals)`: Precise rounding.

### Usage Example
```java
BigDecimal total = MoneyUtils.add(
    new BigDecimal("100.50"), 
    new BigDecimal("50.25")
); // 150.75
```

---

## 📅 DateUtils
Intelligent date/time parsing and formatting.

### Key Methods
- `parse(dateString)`: Auto-detects format (ISO, US, EU, JS timestamps).
- `format(date, pattern)`: Format dates flexibly.
- `getMonthName(dateTime)`: Semantic names.
- `getDaysBetween(date1, date2)`: Calculate intervals.

### Usage Example
```java
LocalDateTime dt = DateUtils.parse("2025-12-25");
LocalDateTime jsDate = DateUtils.parse("1609459200000"); // JS timestamp
String formatted = DateUtils.format(dt, "dd MMM yyyy");
```

---

## 🔄 UnitConverterUtils
Convert between Metric and Imperial units.

### Supported Conversions
- **Temperature**: Celsius ↔ Fahrenheit
- **Weight**: Kilograms ↔ Pounds
- **Distance**: Kilometers ↔ Miles
- **Volume**: Liters ↔ Gallons

### Usage Example
```java
double fahrenheit = UnitConverterUtils.celsiusToFahrenheit(25.0); // 77.0
double miles = UnitConverterUtils.kilometersToMiles(10.0); // 6.21
double pounds = UnitConverterUtils.kilogramsToPounds(75.0); // 165.35
```

---

## 📊 NumberUtils
Safe parsing, formatting, and numeric utilities.

### Key Methods
- `parseInt(string)`: Safe integer parsing (returns `Optional`).
- `parseDecimal(string)`: Safe BigDecimal parsing.
- `toRomanNumeral(number)`: Convert to Roman numerals.
- `formatWithCommas(number)`: Add thousand separators.

### Usage Example
```java
Optional<Integer> num = NumberUtils.parseInt("12345"); // Optional[12345]
String roman = NumberUtils.toRomanNumeral(1994); // "MCMXCIV"
String formatted = NumberUtils.formatWithCommas(1000000); // "1,000,000"
```

---

## 🌍 GeoUtils
Geographic calculations using the Haversine formula.

### Key Methods
- `distanceBetween(lat1, lon1, lat2, lon2)`: Calculate distance in kilometers.
- `distanceBetweenMiles(lat1, lon1, lat2, lon2)`: Calculate distance in miles.
- `isWithinRadius(centerLat, centerLon, checkLat, checkLon, radiusKm)`: Check if point is within radius.

### Usage Example
```java
double distance = GeoUtils.distanceBetween(
    -15.387, 28.322,  // Lusaka, Zambia
    -17.825, 31.033   // Harare, Zimbabwe
); // ~508 km
```

---

## 📄 PaginationUtils
Calculate database offsets and pagination metadata.

### Key Methods
- `getOffset(pageNumber, pageSize)`: Calculate SQL LIMIT offset.
- `getTotalPages(totalItems, pageSize)`: Calculate total page count.
- `isValidPage(pageNumber, totalPages)`: Validate page number.

### Usage Example
```java
int offset = PaginationUtils.getOffset(3, 20); // 40 (skip first 40 items)
int totalPages = PaginationUtils.getTotalPages(150, 20); // 8 pages
```

---

[⬅️ Back to Index](file:///d:/samp/bobsutils/docs/index.md)
