package com.company.bai3;

public class Vehicle {
    protected double  X,Y,angle,velocity,turnSpeed,acceleration;
    public Vehicle() {
        this.X = 0;
        this.Y = 0;
        this.angle = 0;
        this.velocity = 0;
        this.turnSpeed = 0;
        this.acceleration = 0;
    }

    public Vehicle(double X, double Y, double velocity, double turnSpeed, double acceleration) {
        this.X = X;
        this.Y = Y;
        if (Y == 0 && X == 0) {
            this.angle = 0;
        } else {
            if (Y == 0) {
                this.angle = 0;
            } else {
                double sinAngle = Math.sin(Y / Math.sqrt(X * X + Y * Y));
                this.angle = Math.asin(sinAngle);
            }
        }
        this.velocity = velocity;
        this.turnSpeed = turnSpeed;
        this.acceleration = acceleration;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getAngle() {
        return angle;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getTurnSpeed() {
        return turnSpeed;
    }

    public void setX(double X) {
        this.X = X;
    }

    public void setY(double Y) {
        this.Y = Y;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setTurnSpeed(double turnSpeed) {
        this.turnSpeed = turnSpeed;
    }

    public void ahead() {
        this.Y += this.velocity;
        currentAngle();
    }

    public void turnLeft() {
        this.X += this.turnSpeed;
        currentAngle();
    }

    public void turnRight() {
        this.X -= this.turnSpeed;
        currentAngle();
    }

    public void display() {
        System.out.println("Tọa độ hiện tại của xe là: X = " + this.X + " và Y = " + this.Y + " Góc: " + angle);
    }

    public void ahead(double distance) {
        this.Y += distance;
        this.velocity = Math.sqrt(2 * this.acceleration * distance + this.velocity * this.velocity);
        currentAngle();
    }

    public void turnLeft(double degree) {
        this.X += this.turnSpeed * Math.cos(degree);
        this.Y += this.turnSpeed * Math.sin(degree);
        currentAngle();
    }

    public void turnRight(double degree) {
        this.X += this.turnSpeed * Math.cos(degree);
        this.Y += this.turnSpeed * Math.sin(degree);
        currentAngle();
    }

    public void currentAngle() {
        if (Y == 0 && X == 0) {
            this.angle = 0;
        } else {
            if (Y == 0) {
                this.angle = 0;
            } else {
                double sinAngle = Math.sin(Y / Math.sqrt(X * X + Y * Y));
                this.angle = Math.asin(sinAngle);
            }
        }
    }

    public void move(){
        
    }
    public static void main(String[] args) {
        Vehicle myCar = new Vehicle(12.23, 30, 5, 7, 0.8);
        myCar.ahead();
        myCar.display();
        for (int i = 0; i < 2; i++) {
            myCar.turnLeft();
        }
        myCar.display();
        myCar.ahead(30);
        myCar.display();
        myCar.turnLeft(45);
        myCar.display();
       
    }
}
