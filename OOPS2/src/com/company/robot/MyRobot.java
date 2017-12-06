package com.company.robot;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class MyRobot extends Robot {

    public void run() {
        setAdjustRadarForGunTurn(true);
        while (true) {
            turnRadarRight(10000);
            ahead(500);
            turnLeft(90);
        }
    }
    public void onScannedRobot(ScannedRobotEvent e) {
        turnRight(e.getBearing());
        fire(3);
        ahead(e.getDistance());
    }

}
