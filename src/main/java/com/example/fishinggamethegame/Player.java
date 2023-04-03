package com.example.fishinggamethegame;

/**
 * A Player.
 * @author Arman Chinai & Colin Doig
 * @version 06042023
 */
public class Player {
    private static int fishCount = 0;
    private static int coinCount = 0;
    private static int currentScore = 0;
    private static boolean oceanUnlocked = false;
    private static String lastStage = null;
    private static int catchThreshold = 90;
    public Player() {
    }

    /**
     * Get the current fishCount of the Player.
     * @return a positive integer representing the current number of fish owned by the Player.
     */
    public static int getFishCount() {
        return fishCount;
    }

    /**
     * Set the fishCount of the Player.
     * @param fishCount a positive integer representing the new number of fish owned by the Player.
     */
    public static void setFishCount(final int fishCount) {
        Player.fishCount = fishCount;
    }

    /**
     * Get the current coinCount of the Player.
     * @return a positive integer representing the current number of coins the Player has
     */
    public static int getCoinCount() {
        return coinCount;
    }

    /**
     * Get the currentScore of the Player.
     * @return a positive integer representing the current score of the Player
     */
    public static int getCurrentScore() {
        return currentScore;
    }

    /**
     * Set the currentScore of the Player.
     * @param currentScore A positive integer representing the new score of the Player
     */
    public static void setCurrentScore(final int currentScore) {
        Player.currentScore = currentScore;
    }

    /**
     * Set the coinCount of the Player.
     * @param coinCount a positive integer representing the new number of coins the Player has
     */
    public static void setCoinCount(final int coinCount) {
        Player.coinCount = coinCount;
    }

    public static boolean getOceanUnlocked() {
        return oceanUnlocked;
    }

    public static void unlockOcean() {
        Player.oceanUnlocked = true;
    }

    public static String getLastStage() {
        return lastStage;
    }

    public static void setLastStage(final String lastStage) {
        Player.lastStage = lastStage;
    }

    public static int getCatchThreshold() {
        return catchThreshold;
    }

    public static void decrementThreshold() {
        Player.catchThreshold -= 5;
    }
}
