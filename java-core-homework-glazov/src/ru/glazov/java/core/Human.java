package ru.glazov.java.core;

import static ru.glazov.java.core.Track.trackLenght;
import static ru.glazov.java.core.Wall.wallHight;

public class Human implements Sportsmen {

    public int maxJumpHightHuman;
    public int maxDistanceHuman;

    void humanJumps() {
        System.out.println("Human can jump");
    }

    void humanRuns() {
        System.out.println("Human can run");
    }

    @Override
    public void jump() {
        if (maxJumpHightHuman > wallHight) {
            System.out.println("Player Human jumped over the wall!");
        } else System.out.println("Player Human jump: FALSE!");
    }

    @Override
    public void run() {
        if (maxDistanceHuman >= trackLenght) {
            System.out.println("Player Human finished!");
        } else System.out.println("Player Human run: FALSE!");
    }
}
