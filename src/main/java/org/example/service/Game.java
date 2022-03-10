package org.example.service;

import org.example.controller.StdInController;
import org.example.controller.UserInputController;
import org.example.domain.Track;
import org.example.domain.competitor.Hulk;
import org.example.domain.competitor.Mobile;
import org.example.domain.competitor.MobileComparator;
import org.example.domain.competitor.vehicles.cheater.CheatingVehicles;
import org.example.persistance.FileRankingRepository;

import org.example.domain.competitor.vehicles.Car;
import org.example.domain.competitor.vehicles.Vehicle;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private final Track[] tracks = new Track[3];
    private final Set<Mobile> outOfRaceCompetitors = new HashSet<>();
    private final List<Mobile> competitors = new ArrayList<>();
    private boolean winnerNotKnown = true;
    private Track selectedTrack;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private final FileRankingRepository rankingRepository = new FileRankingRepository();

    private final UserInputController userInputController = new StdInController();

    //start
    public void start() throws Exception {
        System.out.println("Welcome to the \"Racing Game\" ! \uD83D\uDE97");
        System.out.println();

        initializeTracks();

        selectedTrack = getSelectedTrackFromUser();


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
        System.out.println();
    }

    //track choice
    private Track getSelectedTrackFromUser() throws Exception {

        try {
            int trackNumber = userInputController.getSelectedTrack();
            return tracks[trackNumber - 1];
        }catch (InputMismatchException e){
            throw new Exception("You have entered an invalid value");
        }catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException("You have entered an invalid number");
        }



    }

    //competitors
    public void initializeCompetitors() {
        int playerCount = userInputController.getPlayerCount();
        for(int i = 0; i < playerCount; i++){
            System.out.println("** Preparing player "+ (i + 1)+ " for the race. **");
            System.out.println();
            Mobile mobile = createCompetitor();

            System.out.println();
            competitors.add(mobile);
        }

    }

    private void setCommonVehicleProperties(Vehicle vehicle) {
        vehicle.setName(userInputController.getVehicleName());
        vehicle.setFuellevel(30);
        vehicle.setMaxSpeed(300);
        vehicle.setMileage(ThreadLocalRandom.current().nextDouble(8,15));
        System.out.println("Fuel level for "+ vehicle.getName() + ": "+ vehicle.getFuellevel());
        System.out.println("Max speed for "+ vehicle.getName() + ": "+ vehicle.getMaxSpeed());
        System.out.println("Mileage for "+ vehicle.getName() + ": "+ df.format(vehicle.getMileage()));
    }





    //round
    private void playOneRound(){
        System.out.println();
        System.out.println("New Round \u2605");


        for (Mobile competitor : competitors) {

            System.out.println();
            System.out.println("It's " + competitor.getName() + "'s turn.");
            if(!competitor.canMove()){
                System.out.println("Sorry, you are out of race..");
                outOfRaceCompetitors.add(competitor);
                continue;
            }
            double speed = userInputController.getVehicleAccelerationFromUser();
            competitor.accelerate(speed,1);
            if(competitor.getTotalTraveledDistance() >= selectedTrack.getLength()){
                System.out.println();
                System.out.println("The winner is :" + competitor.getName());
                winnerNotKnown = false;
                break;
            }
        }
    }


    private void loopRounds(){
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


    private void displayCompetitorsType(){
        System.out.println("How would you like to enter the race ?");
        System.out.println("1.Using a car.");
        System.out.println("2.I feel lucky. I will try Hulk.");
    }

    private Mobile createCompetitor(){
        displayCompetitorsType();
        int competitorType = userInputController.getCompetitorType();

        switch(competitorType) {
            case 0:
                CheatingVehicles cheatingVehicles = new CheatingVehicles();
                setCommonVehicleProperties(cheatingVehicles);
                return cheatingVehicles;

            case 1:
                Car car = new Car();
                setCommonVehicleProperties(car);
                return car;

            case 2:
                System.out.println("Hulk is here!");
                return new Hulk();

            default:
                System.out.println("Please select a valid option ");
               return createCompetitor();
        }

    }

}