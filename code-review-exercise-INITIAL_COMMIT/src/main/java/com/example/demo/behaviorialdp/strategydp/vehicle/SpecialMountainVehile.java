package com.example.demo.behaviorialdp.strategydp.vehicle;

import com.example.demo.behaviorialdp.strategydp.DriveStrategy;
import com.example.demo.behaviorialdp.strategydp.SpecialDriveStrategy;

public class SpecialMountainVehile extends Vehicle{
    SpecialMountainVehile() {
        super(new SpecialDriveStrategy());
    }
}
