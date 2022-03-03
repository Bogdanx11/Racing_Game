package org.example;

import org.example.competitor.Mobile;
import org.example.utils.ScannerUtil;
import org.example.competitor.vehicles.Car;
import org.example.competitor.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private Track[] tracks = new Track[3];

    private List<Mobile> competitors = new ArrayList<>();



    //start
    public void start() {
        System.out.println("Welcome to the Racing Game");

        initializeTracks();

        Track selectedTrack = getSelectedTrackFromUser();

        System.out.println("Selected Track: "+ selectedTrack.getName());

        initializeCompetitors();

        playOneRound();
    }

    //round
    private void playOneRound() {
        System.out.println("New Round.");


        for (Mobile competitor : competitors) {

            System.out.println("It's " + competitor.getName() + "'s turn.");
            double speed = getVehicleAccelerationFromUser();
            competitor.accelerate(speed,1);
            System.out.println();
        }
    }

    //track
    private void initializeTracks(){
        Track track1 = new Track();
        track1.setName("Highway");
        track1.setLength(200);
        tracks[0] = track1;

        Track track2 = new Track();
        track2.setName("Street Circuit");
        track2.setLength(100);
        tracks[1] = track2;

        displayTracks();
    }

    //display tracks
    private void displayTracks(){
        System.out.println("Available tracks :");
        for(int i = 0; i < tracks.length; i++){
            if (tracks[i] != null){
            System.out.println((i+1) +"."+tracks[i].getName()+": "+tracks[i].getLength());
            }
        }
    }

    //track choice
    private Track getSelectedTrackFromUser(){
        System.out.println("Please select a track :");
        int trackNumber = ScannerUtil.nextIntAndMoveToTheNextLine();
        return tracks[trackNumber - 1];
    }

    //competitors
    public void initializeCompetitors() {
        int playerCount = getPlayerCountFromUser();
        for(int i = 0; i < playerCount; i++){
            System.out.println("Preparing player "+ (i + 1)+ " for the race.");
            Vehicle vehicle = new Car();
            vehicle.setName(getVehicleNameFromUser());
            vehicle.setFuellevel(30);
            vehicle.setMaxSpeed(300);
            vehicle.setMileage(ThreadLocalRandom.current().nextDouble(8,15));
            System.out.println("Fuel level for "+ vehicle.getName() + ": "+ vehicle.getFuellevel());
            System.out.println("Max speed for "+ vehicle.getName() + ": "+ vehicle.getMaxSpeed());
            System.out.println("Mileage for "+ vehicle.getName() + ": "+ vehicle.getMileage());

            System.out.println();
            competitors.add(vehicle);
        }

    }

    //number of players
    private int getPlayerCountFromUser() {
        System.out.println("Please enter number of players : ");
        return ScannerUtil.nextIntAndMoveToTheNextLine();
    }


    //vehicle name
    private String getVehicleNameFromUser(){
        System.out.println("Please enter vehicle name: ");
       return ScannerUtil.nextLine();
    }

    //get acceleration
    private double getVehicleAccelerationFromUser(){
        System.out.println("Please enter the acceleration :");
        return ScannerUtil.nextDoubleAndMoveToTheNextLine();
    }

}