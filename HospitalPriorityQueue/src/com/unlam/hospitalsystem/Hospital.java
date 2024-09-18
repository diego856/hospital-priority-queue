package com.unlam.hospitalsystem;

import com.unlam.hospitalsystem.Exception.EmptyQueueException;

import java.util.List;

public class Hospital {
    public static void main(String[] args) throws EmptyQueueException {
        List<Patient> listaDePacientes = List.of(new Patient("Marco", "Cold", UrgencyLevel.NO_URGENCY),
                new Patient("Victor", "Resfriado", UrgencyLevel.NO_URGENCY),
                new Patient("Tomy", "Dolor de Cabeza", UrgencyLevel.LITTLE_URGENCY),
                new Patient("Tomás", "Dolor de Cabeza", UrgencyLevel.LITTLE_URGENCY),
                new Patient("Christian", "Fractura", UrgencyLevel.URGENCY),
                new Patient("Thiago", "Ataque al corazón", UrgencyLevel.EMERGENCY),
                new Patient("Juan Manuel", "Accidente en General Paz", UrgencyLevel.RESUSCITATE));
        WaitRoom waitingRoom = new WaitRoom(listaDePacientes.size());

        // Agrega cada paciente a la sala de espera
        listaDePacientes.stream().forEach(p -> waitingRoom.addPatient(p));

        System.out.println("Lista de Pacientes Original");
        System.out.println("---------------------");
        listaDePacientes.stream().forEach(p -> System.out.println(p + "\n"));
        System.out.println("---------------------\n");

        System.out.println("Comenzando a atender pacientes...");
        System.out.println("---------------------------");
        int size = waitingRoom.getCapacity() - 1;
        for (int i = 0; i < size; i++) { // a
        	System.out.println("\nAtendiendo al siguiente paciente:");
            System.out.println(waitingRoom.assistPatient());
        }

        System.out.println("\nPrioridad de sala de espera luego de atender:");
        waitingRoom.showPriorityQueue();
        System.out.println("---------------------------");
    }
}