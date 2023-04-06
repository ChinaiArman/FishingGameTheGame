package com.example.fishinggamethegame;

/**
 * A Player.
 * @author Arman Chinai & Colin Doig
 * @version 06042023
 */
public class Player {
    private static int fishCount = 0;
    private static int coinCount = 25;
    private static int currentScore = 0;
    private static boolean oceanUnlocked = false;
    private static String lastScene = null;
    private static int catchThreshold = 120;
    private static int maxBaitStrength = 150;
    private static int rodLevel = 0;
    private static int baitLevel = 0;

    public static int getRodLevel() {
        return rodLevel;
    }

    public static void incrementRodLevel() {
        Player.rodLevel += 1;
    }

    public static int getBaitLevel() {
        return baitLevel;
    }

    public static void incrementBaitLevel() {
        Player.baitLevel += 1;
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

    /**
     * Determine whether the Player has unlocked the Ocean.
     * @return true if the Player has unlocked the Ocean, else false
     */
    public static boolean isOceanUnlocked() {
        return oceanUnlocked;
    }

    /**
     * Set oceanUnlocked to true for the Player.
     */
    public static void unlockOcean() {
        Player.oceanUnlocked = true;
    }

    /**
     * Get the previous Scene the Player was in.
     * @return a String representing the previous Scene
     */
    public static String getLastScene() {
        return lastScene;
    }

    /**
     * Set lastScene to the previous Scene the Player was in.
     * @param lastScene a String representing the previous Scene
     */
    public static void setLastScene(final String lastScene) {
        Player.lastScene = lastScene;
    }

    /**
     * Get the current catchThreshold of the Player.
     * @return a positive integer representing the current difficulty of catching fish
     */
    public static int getCatchThreshold() {
        return catchThreshold;
    }

    /**
     * Decrease the catchThreshold of the Player, making it easier to catch fish
     */
    public static void decrementThreshold() {
        Player.catchThreshold -= 5;
    }

    /**
     * Get the current maxBaitStrength of the Player.
     * @return a positive integer representing the current strength of the Player's fishing bait
     */
    public static int getMaxBaitStrength() {
        return maxBaitStrength;
    }

    /**
     * Decrease the maxBaitStrength of the Player by 10.
     */
    public static void increaseBaitStrength() {
        Player.maxBaitStrength -= 10;
    }
}
