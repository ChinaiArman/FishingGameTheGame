package com.example.fishinggamethegame.classes;

public class Consumable extends Item implements Fishable {
    private final int sellPrice;
    private int buyPrice;
    private int luck;

    public Consumable(String name, Rarity rarity, int sellPrice, int buyPrice, int luck) {
        super(name, rarity);
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.luck = luck;
    }

    @Override
    public boolean catchThing() {
        return false;
    }

    @Override
    public boolean escape() {
        return false;
    }
}
