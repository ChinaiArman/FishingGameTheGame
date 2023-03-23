package com.example.fishinggamethegame;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerCharacter extends Character {
    private String currentLocation;
    private int level = 1;
    private HashMap<String, Integer> stats;
    private int balance = 50;
    private ArrayList<Fish> caughtFish;

    public PlayerCharacter(String name, String currentLocation, int[] stats) {
        super(name);
        this.currentLocation = currentLocation;
        this.stats.put("Strength", stats[0]);
        this.stats.put("Stamina", stats[1]);
    }
}
