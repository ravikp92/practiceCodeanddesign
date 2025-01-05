package com.example.demo.behaviorialdp.strategydp.vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle normal=new NormalVehicle();
        normal.callStrategyDrive();
        Vehicle special=new SpecialMountainVehile();
        special.callStrategyDrive();
    }
}
