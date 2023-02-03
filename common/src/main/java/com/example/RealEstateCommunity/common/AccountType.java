package com.example.RealEstateCommunity.common;

public enum AccountType {
    REALTOR("공인중개사"),LESSOR("임대인"),LESSEE("임차인");

    private final String role;

    AccountType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}


