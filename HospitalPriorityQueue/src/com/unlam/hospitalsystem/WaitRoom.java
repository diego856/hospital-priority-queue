package com.unlam.hospitalsystem;

import com.unlam.hospitalsystem.Exception.EmptyQueueException;

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
            if(getLastIndex() > 0)
                heapifyUp(getLastIndex());  // Reorganize queue
        } else {
            System.out.println("La cola de prioridad está + llena.");
        }
    }

    public Patient assistPatient() throws EmptyQueueException {
        if (patients.isEmpty()) {
            throw new EmptyQueueException("La sala de espera esta vacía.");
            //return null;
        }

        Patient attendedPatient = patients.get(0);
        patients.set(0, getLatestPatient());
        patients.remove(getLastIndex());

        heapifyDown(0); // Reorganiza la cola de prioridad

        return attendedPatient;
    }

    private void heapifyUp(int index) {
    	int parentIndex = (index - 1) / 2;

        while (compare(patients.get(index), patients.get(parentIndex)) < 0) {
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

    private int compare(Patient patient1, Patient patient2) {
        // Prioresuscitate > emergency > urgency > little urgency > no urgency

        int index1 = patient1.getUrgencyLevel().getValue();
        int index2 = patient2.getUrgencyLevel().getValue();

        return Integer.compare(index1, index2);
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

    private Patient getLatestPatient() {
        return patients.get(getLastIndex());
    }

    private int getLastIndex() {
        return patients.size() - 1;
    }
}
