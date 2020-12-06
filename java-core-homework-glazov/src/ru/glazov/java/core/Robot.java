package ru.glazov.java.core;

import static ru.glazov.java.core.Track.trackLenght;
import static ru.glazov.java.core.Wall.wallHight;

public class Robot implements Sportsmen {

    int maxJumpHightRobot;
    int maxDistanceRobot;

    void robotJumps(){
        System.out.println("Robot can jump\n");
    }

    void robotRuns(){
        System.out.println("Robot can run\n");
    }

    @Override
    public void jump() {
        if (maxJumpHightRobot > wallHight) {
            System.out.println("Player Robot jumped over the wall!\n");
        } else System.out.println("Player Robot jump: FALSE!\n");
    }

    @Override
    public void run() {
        if (maxDistanceRobot >= trackLenght) {
            System.out.println("Player Robot finished!\n");
        } else System.out.println("Player Robot run: FALSE!\n");
    }
}
