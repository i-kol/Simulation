package com.example.entities;

public class Grass extends Entity {
    protected int grassHealthRecover;
    public final static int GRASS_HEALTH_RECOVER = 5;

    public Grass(int grassHealthRecover) {
        this.grassHealthRecover = grassHealthRecover;
    }
}
