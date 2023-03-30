package com.example.fishinggamethegame;

// banana
public class Player {
    private static int fishCount = 0;
    private static int coinCount = 0;
    private static int currentScore = 0;
    public Player() {
    }

    public static int getFishCount() {
        return fishCount;
    }

    public static void setFishCount(int fishCount) {
        Player.fishCount = fishCount;
    }

    public static int getCoinCount() {
        return coinCount;
    }

    public static int getCurrentScore() {
        return currentScore;
    }

    public static void setCurrentScore(int currentScore) {
        Player.currentScore = currentScore;
    }

    public static void setCoinCount(int coinCount) {
        Player.coinCount = coinCount;
    }


}
