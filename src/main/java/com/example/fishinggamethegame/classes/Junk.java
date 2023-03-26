package com.example.fishinggamethegame.classes;

public class Junk extends Item implements Fishable {
    private final int sellPrice;
    public Junk(String name, int sellPrice){
        super(name, Rarity.Common);
        this.sellPrice = sellPrice;
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
