package org.example;

import org.example.utils.ScannerUtil;
import org.example.vehicles.Vehicle;

public class Game {

    private Track[] tracks = new Track[3];



    //start
    public void start() {
        System.out.println("Welcome to the Racing Game");

        initializeTracks();

        Track selectedTrack = getSelectedTrackFromUser();

        System.out.println("Selected Track: "+ selectedTrack.getName());
        int playerCount = getPlayerCountFromUser();
        System.out.println("Number of players: " +playerCount );
        String vehicleName = getVehicleNameFromUser();
        System.out.println("Vehicle name: " + vehicleName );

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
}