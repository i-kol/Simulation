package com.example.entities;

public class Grass extends Entity {
    public final static int GRASS_HEALTH_RECOVER = 5;
    protected int grassHealthRecover;

    public Grass(int grassHealthRecover) {
        this.grassHealthRecover = grassHealthRecover;
    }
}
