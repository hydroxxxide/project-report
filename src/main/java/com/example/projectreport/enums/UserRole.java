package com.example.projectreport.enums;

public enum UserRole {
    USER("User"),
    ADMIN("Admin");

    private final String value;

    private UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
