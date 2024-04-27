package com.unlam.hospitalsystem;

class Patient {
    private Long id;
    private String name;
    private String condition;
    private UrgencyLevel urgencyLevel;

    public Patient(String name, String condition, UrgencyLevel urgencyLevel) {
        this.name = name;
        this.condition = condition;
        this.urgencyLevel = urgencyLevel;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public UrgencyLevel getUrgencyLevel() {
        return urgencyLevel;
    }

    @Override
    public String toString() {
        return " - Name: " + name
                + "\n - Condition: " + condition
                + "\n - Urgency Level: " + urgencyLevel;
    }
}
