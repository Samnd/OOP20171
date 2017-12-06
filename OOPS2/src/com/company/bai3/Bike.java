package com.company.bai3;

public class Bike extends Vehicle {

    public Bike() {
    }

    public Bike(double X, double Y, double velocity, double turnSpeed, double acceleration) {
        super(X, Y, velocity, turnSpeed, acceleration);
    }

    @Override
    public void move() {
        this.ahead(10);
        this.turnRight(10);
        for (int i = 0; i < 3; i++) {
            this.ahead(10);
        }
    }
}

