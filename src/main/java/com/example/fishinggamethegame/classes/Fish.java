package com.example.fishinggamethegame.classes;

public class Fish implements Fishable {
    private final String type;
    private final Rarity rarity;
    private final int sellPrice;

    public Fish(String type, Rarity rarity, int sellPrice) {
        this.type = type;
        this.rarity = rarity;
        this.sellPrice = sellPrice;
    }

    @Override
    public boolean escape(){
        return true;
    }

    @Override
    public boolean catchThing() {
        return true;
    }
}
