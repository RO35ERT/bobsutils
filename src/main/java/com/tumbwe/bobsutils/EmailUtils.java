package com.tumbwe.bobsutils;

import okhttp3.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

/**
 * Utilities for sending emails via different providers (SMTP, Brevo, Mailgun).
 */
public class EmailUtils {

    /**
     * Sends a basic email via SMTP (e.g. Gmail).
     */
    public static void sendSmtp(String host, int port, String username, String password, 
                                String from, String to, String subject, String body) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
    }

    /**
     * Sends an email via Brevo API using OkHttp.
     */
    public static boolean sendBrevo(String apiKey, String fromEmail, String toEmail, String subject, String htmlContent) {
        OkHttpClient client = new OkHttpClient();
        String json = String.format(
            "{\"sender\":{\"email\":\"%s\"},\"to\":[{\"email\":\"%s\"}],\"subject\":\"%s\",\"htmlContent\":\"%s\"}",
            fromEmail, toEmail, subject, htmlContent.replace("\"", "\\\"")
        );

        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("https://api.brevo.com/v3/smtp/email")
                .post(body)
                .addHeader("api-key", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Sends an email via Mailgun API using OkHttp.
     */
    public static boolean sendMailgun(String apiKey, String domain, String from, String to, String subject, String text) {
        OkHttpClient client = new OkHttpClient();
        String credentials = Credentials.basic("api", apiKey);

        RequestBody body = new FormBody.Builder()
                .add("from", from)
                .add("to", to)
                .add("subject", subject)
                .add("text", text)
                .build();

        Request request = new Request.Builder()
                .url("https://api.mailgun.net/v3/" + domain + "/messages")
                .post(body)
                .addHeader("Authorization", credentials)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Sends an email via SendGrid API.
     */
    public static boolean sendSendGrid(String apiKey, String from, String to, String subject, String htmlContent) {
        OkHttpClient client = new OkHttpClient();
        String json = String.format(
            "{\"personalizations\":[{\"to\":[{\"email\":\"%s\"}]}],\"from\":{\"email\":\"%s\"},\"subject\":\"%s\",\"content\":[{\"type\":\"text/html\",\"value\":\"%s\"}]}",
            to, from, subject, htmlContent.replace("\"", "\\\"")
        );

        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("https://api.sendgrid.com/v3/mail/send")
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Sends an email via SparkPost API.
     */
    public static boolean sendSparkPost(String apiKey, String from, String to, String subject, String htmlContent) {
        OkHttpClient client = new OkHttpClient();
        String json = String.format(
            "{\"content\":{\"from\":\"%s\",\"subject\":\"%s\",\"html\":\"%s\"},\"recipients\":[{\"address\":\"%s\"}]}",
            from, subject, htmlContent.replace("\"", "\\\""), to
        );

        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("https://api.sparkpost.com/api/v1/transmissions")
                .post(body)
                .addHeader("Authorization", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        } catch (IOException e) {
            return false;
        }
    }
}
