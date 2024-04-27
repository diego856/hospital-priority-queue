package com.unlam.hospitalsystem;

public class Hospital {
    public static void main(String[] args) {
    	WaitRoom waitingRoom = new WaitRoom(5);
    	
    	waitingRoom.addPatient(new Patient("Leonardo", "Fracture", "urgency"));
    	waitingRoom.addPatient(new Patient("Patricio", "Headache", "little urgency"));
    	waitingRoom.addPatient(new Patient("Juan", "Heart attack", "emergency"));
    	waitingRoom.addPatient(new Patient("Florencia", "Cold", "no urgency"));
    	waitingRoom.addPatient(new Patient("Diego", "Serious accident", "resuscitate"));

        System.out.println("Original queue:");
        waitingRoom.showPriorityQueue();

        int size = waitingRoom.getCapacity() - 1; //Attending all but the least urgent
        for (int i = 0; i < size; i++) { // a
        	System.out.println("\nAttending to the next Patient:");
            System.out.println(waitingRoom.assistPatient());
        }

        System.out.println("\nPriority waiting room after attending:");
        waitingRoom.showPriorityQueue();
    }
}