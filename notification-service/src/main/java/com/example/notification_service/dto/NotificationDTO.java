package com.example.notification_service.dto;

public class NotificationDTO {
    private String type;
    private String recipient;
    private String message;

    public NotificationDTO(String type, String recipient, String message) {
        this.type = type;
        this.recipient = recipient;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
