package com.example.fishinggamethegame;

public class Item {
    private final String name;
    private final Rarity rarity;
    private final int sellPrice;

    public Item(String name, Rarity rarity, int sellPrice){
        this.name = name;
        this.rarity = rarity;
        this.sellPrice = sellPrice;
    }
}
