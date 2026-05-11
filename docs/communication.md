# 📱 Communication & Marketing

Utilities for sending emails, generating barcodes, and handling phone numbers.

---

## 📧 EmailUtils
A unified interface for various email providers.

### Supported Providers
- **SMTP**: Standard mail server support.
- **Brevo**: API-based sending.
- **SendGrid**: API-based sending.
- **Mailgun**: API-based sending.
- **Resend**: Modern developer-focused API.

### Usage Example
```java
EmailUtils.sendSmtp(
    "host", 587, "user", "pass",
    "from@example.com", "to@example.com",
    "Subject", "<h1>Hello!</h1>"
);
```

---

## 🏁 QrCodeUtils
Generate QR codes as Base64 strings or files.

### Key Methods
- `generateBase64(text, size)`: Returns a data URI string.
- `generatePng(text, size, foreground, background)`: Custom colors.

### Usage Example
```java
String base64 = QrCodeUtils.generateBase64("https://google.com", 300);
// Use base64 in <img src="...">
```

---

## 📞 PhoneUtils
Specialized utilities for Zambian mobile networks.

### Key Methods
- `normalizeZambian(phone)`: Normalizes `097...` or `+26097...` to `26097...`.
- `getZambianNetwork(phone)`: Identifies if a number belongs to `AIRTEL`, `MTN`, or `ZAMTEL`.
- `isValidZambian(phone)`: Boolean validation.

### Usage Example
```java
String normalized = PhoneUtils.normalizeZambian("0977123456"); // "260977123456"
Network net = PhoneUtils.getZambianNetwork(normalized); // Network.AIRTEL
```

---

[⬅️ Back to Index](file:///d:/samp/bobsutils/docs/index.md)
