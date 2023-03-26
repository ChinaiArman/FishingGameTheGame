package com.example.fishinggamethegame.classes;

public class NonPlayerCharacter extends Character {
    private String location;
    private String type;

    public NonPlayerCharacter(String name, String location, String type) {
        super(name);
        this.location = location;
        this.type = type;
    }

}
