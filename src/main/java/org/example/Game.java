package org.example;

import org.example.utils.ScannerUtil;

public class Game {

    //create scanner
    ScannerUtil scannerUtil = new ScannerUtil();


    //start
    public void start() {
        System.out.println("Welcome to the Racing Game");
        int playerCount = getPlayerCountFromUser();
        System.out.println("Number of players: " +playerCount );
        String vehicleName = getVehicleNameFromUser();
        System.out.println("Vehicle name: " + vehicleName );

    }


    //number of players
    private int getPlayerCountFromUser() {
        System.out.println("Please enter number of players : ");
        return scannerUtil.nextIntAndMoveToTheNextLine();
    }


    //vehicle name
    private String getVehicleNameFromUser(){
        System.out.println("Please enter vehicle name: ");
       return scannerUtil.nextLine();
    }
}