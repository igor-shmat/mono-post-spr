package com.fintech.monopostspr.enums;

public enum ParcelStatus {
    NEW,
    DELIVERED,
    OVERDUE;

    public static ParcelStatus generateRandomStatus() {
        Double rand = Math.random();
        if (rand <= 0.80) {
            return NEW;
        } else
            return DELIVERED;
    }
}
