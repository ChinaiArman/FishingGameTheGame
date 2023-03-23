package com.example.fishinggamethegame;

public class Fish {
    private final String type;
    private final Rarity rarity;
    private final int sellPrice;

    public Fish(String type, Rarity rarity, int sellPrice) {
        this.type = type;
        this.rarity = rarity;
        this.sellPrice = sellPrice;
    }
}
