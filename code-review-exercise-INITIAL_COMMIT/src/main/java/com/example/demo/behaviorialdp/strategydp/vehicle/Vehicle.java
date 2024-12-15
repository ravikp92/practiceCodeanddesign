package com.example.demo.behaviorialdp.strategydp.vehicle;

import com.example.demo.behaviorialdp.strategydp.DriveStrategy;

public class Vehicle {

    //vehicle has a drive strategy relationship
    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy=driveStrategy;
    }

    public void callStrategyDrive(){
        this.driveStrategy.drive();
    }
}
