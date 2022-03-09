package org.example.domain.competitor;

public interface Mobile {

    double accelerate(double speed, double timeInHours);

    double getTotalTraveledDistance();

    boolean canMove();
    String getName();
}
