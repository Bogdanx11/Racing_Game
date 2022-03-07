package org.example;

import org.example.competitor.Mobile;
import org.example.competitor.MobileComparator;
import org.example.persistance.FileRankingRepository;
import org.example.utils.ScannerUtil;
import org.example.competitor.vehicles.Car;
import org.example.competitor.vehicles.Vehicle;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private Track[] tracks = new Track[3];
    private Set<Mobile> outOfRaceCompetitors = new HashSet<>();
    private List<Mobile> competitors = new ArrayList<>();
    private boolean winnerNotKnown = true;
    private Track selectedTrack;

    private FileRankingRepository rankingRepository = new FileRankingRepository();


    //start
    public void start() throws Exception {
        System.out.println("Welcome to the Racing Game");

        initializeTracks();

        selectedTrack = getSelectedTrackFromUser();

        System.out.println("Selected Track: "+ selectedTrack.getName());

        initializeCompetitors();

        loopRounds();

        processRankings();
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
    private Track getSelectedTrackFromUser() throws Exception {
        System.out.println("Please select a track :");
        try {
            int trackNumber = ScannerUtil.nextIntAndMoveToTheNextLine();
            return tracks[trackNumber - 1];
        }catch (InputMismatchException e){
            throw new Exception("You have entered an invalid value");
        }catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException("You have entered an invalid number");
        }



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
    private double getVehicleAccelerationFromUser() throws Exception{
        System.out.println("Please enter the acceleration :");

        try {
            return ScannerUtil.nextDoubleAndMoveToTheNextLine();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid value. Please try again!");
        return getVehicleAccelerationFromUser();
        }

    }


    //round
    private void playOneRound() throws Exception {
        System.out.println("New Round.");


        for (Mobile competitor : competitors) {

            System.out.println();
            System.out.println("It's " + competitor.getName() + "'s turn.");
            if(!competitor.canMove()){
                System.out.println("Sorry, you are out of race..");
                outOfRaceCompetitors.add(competitor);
                continue;
            }
            double speed = getVehicleAccelerationFromUser();
            competitor.accelerate(speed,1);
            if(competitor.getTotalTraveledDistance() >= selectedTrack.getLength()){
                System.out.println("The winner is :" + competitor.getName());
                winnerNotKnown = false;
                break;
            }
        }
    }


    private void loopRounds() throws Exception {
        while(winnerNotKnown && outOfRaceCompetitors.size() < competitors.size()) {
            playOneRound();
        }
    }

    //comparator
    public void processRankings(){

        competitors.sort(Collections.reverseOrder(new MobileComparator()));
        System.out.println("Rankings :");

        for(int i =0 ; i< competitors.size(); i++){
            System.out.println((i+1) + "." + competitors.get(i).getName() + " : " + competitors.get(i).getTotalTraveledDistance() );

            rankingRepository.addRankingItem(i+1,competitors.get(i).getName(),competitors.get(i).getTotalTraveledDistance());

        }

        rankingRepository.close();
    }

}