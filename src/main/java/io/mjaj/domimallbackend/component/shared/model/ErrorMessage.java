package io.mjaj.domimallbackend.component.shared.model;

import java.time.LocalDateTime;

public class ErrorMessage {

    private String exception;

    private String message;

    private String path;

    public ErrorMessage(Exception exception, String path){
        this.exception = exception.getClass().getName();
        this.message = exception.getMessage();
        this.path = path;
        this.date = LocalDateTime.now();
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getDate() {
        return date;
    }

    private LocalDateTime date;

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", date=" + date +
                '}';
    }
}
