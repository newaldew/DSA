package org.example;

public class ProcessJobWorker implements Runnable {
    private Elevator elevator;

    ProcessJobWorker(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        elevator.startElevator();
    }
}
