package com.unlam.hospitalsystem;

public enum UrgencyLevel {
    RESUSCITATE(1),
    EMERGENCY(2),
    URGENCY(3),
    LITTLE_URGENCY(4),
    NO_URGENCY(5);
    private final int value;
    private UrgencyLevel(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
