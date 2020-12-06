package ru.glazov.java.core;

import static ru.glazov.java.core.Wall.wallHight;

public class Main {

    public static void main(String[] args) {

        Human playerHuman = new Human();
        playerHuman.maxJumpHightHuman = 10;
        playerHuman.maxDistanceHuman = 25;

        Cat playerCat = new Cat();
        playerCat.maxJumpHightCat = 15;
        playerCat.maxDistanceCat = 15;

        Robot playerRobot = new Robot();
        playerRobot.maxJumpHightRobot = 5;
        playerRobot.maxDistanceRobot = 35;

        Wall ourWall = new Wall();
        wallHight = 12;

        Track ourTrack = new Track();
        ourTrack.trackLenght = 20;

        playerCat.catJumps();
        playerHuman.humanJumps();
        playerRobot.robotJumps();

        playerCat.catRuns();
        playerHuman.humanRuns();
        playerRobot.robotRuns();

        playerCat.jump();
        playerHuman.jump();
        playerRobot.jump();

        playerCat.run();
        playerHuman.run();
        playerRobot.run();

        Sportsmen[] athlets = {playerHuman, playerCat, playerRobot};
        Stages[] stages = {ourTrack, ourWall};
        System.out.println("Arrays\n");
        for (Sportsmen athlet : athlets) {
            for (Stages stage : stages)
                if (stage == ourTrack) {
                    athlet.run();
                } else athlet.jump();
        }

    }
}
