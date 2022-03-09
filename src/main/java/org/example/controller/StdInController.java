package org.example.controller;

import org.example.controller.utils.ScannerUtil;



public class StdInController implements UserInputController{
    @Override
    public int getPlayerCount() {
        System.out.println("Please enter number of players : ");
        return ScannerUtil.nextIntAndMoveToTheNextLine();
    }

    @Override
    public int getSelectedTrack()  {
        System.out.println("Please select a track :");

             return ScannerUtil.nextIntAndMoveToTheNextLine();

    }

    @Override
    public String getVehicleName() {
        System.out.println("Please enter vehicle name: ");
        return ScannerUtil.nextLine();
    }

    @Override
    public double getVehicleAccelerationFromUser() {
        System.out.println("Please enter the acceleration :");

        try {
            return ScannerUtil.nextDoubleAndMoveToTheNextLine();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid value. Please try again!");
            return getVehicleAccelerationFromUser();
        }

    }

    @Override
    public int getCompetitorType() {
        return ScannerUtil.nextIntAndMoveToTheNextLine();
    }
}
