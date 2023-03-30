package com.example.fishinggamethegame;

public class Player {
    private static int fishCount = 0;
    private static int coinCount = 0;
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

    public static void setCoinCount(int coinCount) {
        Player.coinCount = coinCount;
    }
}
