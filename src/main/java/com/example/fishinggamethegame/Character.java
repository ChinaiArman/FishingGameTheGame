package com.example.fishinggamethegame;

import java.util.ArrayList;

public class Character {
    private String name;
    private ArrayList<Item> items;

    public Character(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
