package com.unlam.hospitalsystem;

import java.util.List;
import java.util.ArrayList;

class WaitRoom {
    private List<Patient> patients;
    private int capacity;

    public WaitRoom(int capacity) {
        this.capacity = capacity;
        this.patients = new ArrayList<>(capacity);
    }
    
    public int getCapacity(){
    	return this.capacity;
    }

    public void addPatient(Patient Patient) {
        if (patients.size() < capacity) {
            patients.add(Patient);
            heapifyUp(patients.size() - 1);  // Reorganize queue
        } else {
            System.out.println("priority queue is full");
        }
    }

    public Patient assistPatient() {
        if (patients.isEmpty()) {
            System.out.println("priority queue is empty");
            return null;
        }

        Patient attendedPatient = patients.get(0); // First patient from queue
        patients.set(0, patients.get(patients.size() - 1));
        patients.remove(patients.size() - 1);

        heapifyDown(0); // Reorganize queue

        return attendedPatient;
    }

    private void heapifyUp(int index) {
    	int parentIndex = (index - 1) / 2;

        while (index > 0 && compare(patients.get(index), patients.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < patients.size() && compare(patients.get(leftChildIndex), patients.get(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < patients.size() && compare(patients.get(rightChildIndex), patients.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    private int compare(Patient Patient1, Patient Patient2) {
        //resuscitate > emergency > urgency > little urgency > no urgency
        String[] urgencyLevels = {"resuscitate", "emergency", "urgency", "little urgency", "no urgency"};
        int index1 = getIndex(urgencyLevels, Patient1.getUrgencyLevel());
        int index2 = getIndex(urgencyLevels, Patient2.getUrgencyLevel());

        return Integer.compare(index1, index2);
    }

    private int getIndex(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int i, int j) {
        Patient temp = patients.get(i);
        patients.set(i, patients.get(j));
        patients.set(j, temp);
    }

    public void showPriorityQueue() {
        for (Patient Patient : patients) {
            System.out.println(Patient);
        }
    }
}
