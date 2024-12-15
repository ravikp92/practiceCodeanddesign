package com.example.demo.designquestions.elevatorSystem;

public class Floor {

    int floorNumber;
    ExternalDispatcher externalDispatcher;

    Floor(int floorNumber){
        this.floorNumber=floorNumber;
        this.externalDispatcher=new ExternalDispatcher();
    }

    public void pressButoon(Direction direction){
        externalDispatcher.submitExtenralRequest(floorNumber,direction);
    }
}
