package com.example.fishinggamethegame;
import java.util.ArrayList;

public class Player {
    private static int fishCount = 0;
    private static int coinCount = 0;
    private static ArrayList<String> items;

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
