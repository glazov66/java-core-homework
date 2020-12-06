package ru.glazov.java.core;

import static ru.glazov.java.core.Track.trackLenght;
import static ru.glazov.java.core.Wall.wallHight;

public class Cat implements Sportsmen {

    int maxJumpHightCat;
    int maxDistanceCat;

    void catJumps(){
        System.out.println("Cat can jump");
    }

    void catRuns(){
        System.out.println("Cat can run");
    }
    @Override
    public void jump() {
        if (maxJumpHightCat > wallHight) {
            System.out.println("Player Cat jumped over the wall!");
        } else System.out.println("Player Cat jump: FALSE!");
    }

    @Override
    public void run() {
        if (maxDistanceCat >= trackLenght) {
            System.out.println("Player Cat finished!");
        } else System.out.println("Player Cat run: FALSE!");
    }
}
