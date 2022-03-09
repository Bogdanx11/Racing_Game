package org.example.controller;

public interface UserInputController {

    int getPlayerCount();
    int getSelectedTrack() throws Exception;
    String getVehicleName();
    double getVehicleAccelerationFromUser();
    int getCompetitorType();

}
