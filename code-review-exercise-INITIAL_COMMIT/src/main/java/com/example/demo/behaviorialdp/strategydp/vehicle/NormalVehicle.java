package com.example.demo.behaviorialdp.strategydp.vehicle;

import com.example.demo.behaviorialdp.strategydp.DriveStrategy;
import com.example.demo.behaviorialdp.strategydp.NormalDriveStrategy;

//normal vehicle is a vehicle relationship
public class NormalVehicle extends Vehicle{
    NormalVehicle() {
        super(new NormalDriveStrategy());
    }
}
