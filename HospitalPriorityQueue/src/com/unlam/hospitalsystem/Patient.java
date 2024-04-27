package com.unlam.hospitalsystem;

class Patient {
    private String name;
    private String condition;
    private String urgencyLevel
;

    public Patient(String name, String condition, String urgencyLevel) {
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

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", condition='" + condition + '\'' +
                ", urgencyLevel='" + urgencyLevel + '\'' +
                '}';
    }
}
