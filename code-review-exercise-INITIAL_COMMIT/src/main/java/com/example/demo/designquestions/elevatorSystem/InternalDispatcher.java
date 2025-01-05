package com.example.demo.designquestions.elevatorSystem;

import java.util.List;

public class InternalDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;


    public void submitExtenralRequest(int floorNumber, ElevatorCar elevatorCar) {

        //for simplicity, i am following even odd,


    }

    public void submitInternalRequest(int destination, ElevatorCar elevatorCar) {
    }
}
