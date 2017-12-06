package com.company.bai3;

public class Car extends Vehicle {

    public Car(){
        
    }
    
    public Car(double X, double Y, double velocity, double turnSpeed, double acceleration) {
        super(X, Y, velocity, turnSpeed, acceleration);
    }

    @Override
    public void move() {
        this.ahead();
        this.turnLeft();
        for (int i = 0; i < 5; i++) {
            this.ahead(10);
        }
    }
}
