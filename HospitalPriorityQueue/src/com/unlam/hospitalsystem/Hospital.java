package com.unlam.hospitalsystem;

import com.unlam.hospitalsystem.Exception.EmptyQueueException;

import java.util.List;

public class Hospital {
    public static void main(String[] args) throws EmptyQueueException {
        List<Patient> patientList = List.of(new Patient("Marco", "Cold", UrgencyLevel.NO_URGENCY),
                new Patient("Florencia", "Cold", UrgencyLevel.NO_URGENCY),
                new Patient("Patricio", "Headache", UrgencyLevel.LITTLE_URGENCY),
                new Patient("Luca", "Headache", UrgencyLevel.LITTLE_URGENCY),
                new Patient("Leonardo", "Fracture", UrgencyLevel.URGENCY),
                new Patient("Juan", "Heart attack", UrgencyLevel.EMERGENCY),
                new Patient("Diego", "Serious accident", UrgencyLevel.RESUSCITATE));
        WaitRoom waitingRoom = new WaitRoom(patientList.size());

        // Adds every patient to Waiting Room
        patientList.stream().forEach(p -> waitingRoom.addPatient(p));

        // Shows the original patient list
        System.out.println("Original Patient List");
        System.out.println("---------------------");
        patientList.stream().forEach(p -> System.out.println(p));
        System.out.println("---------------------\n");

        System.out.println("Starting to attend patients");
        System.out.println("---------------------------");
        int size = waitingRoom.getCapacity() - 1; //Attending all but the least urgent
        for (int i = 0; i < size; i++) { // a
        	System.out.println("\nAttending to the next Patient:");
            System.out.println(waitingRoom.assistPatient());
        }

        System.out.println("\nPriority waiting room after attending:");
        waitingRoom.showPriorityQueue();
        System.out.println("---------------------------");
    }
}