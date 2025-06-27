package com.example.notification_service.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(String type, String recipient, String message) {
        // Logic to send notification based on type
        switch (type.toLowerCase()) {
            case "email":
                sendEmail(recipient, message);
                break;
            case "sms":
                sendSms(recipient, message);
                break;
            case "push":
                sendPushNotification(recipient, message);
                break;
            default:
                throw new IllegalArgumentException("Unsupported notification type: " + type);
        }
    }

    private void sendEmail(String recipient, String message) {
        // Logic to send email
        System.out.println("Sending email to " + recipient + ": " + message);
    }

    private void sendSms(String recipient, String message) {
        // Logic to send SMS
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }

    private void sendPushNotification(String recipient, String message) {
        // Logic to send push notification
        System.out.println("Sending push notification to " + recipient + ": " + message);
    }

}
