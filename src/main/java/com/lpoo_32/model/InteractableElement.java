package com.lpoo_32.model;

import com.lpoo_32.exceptions.*;

abstract public class InteractableElement implements ElementModel {

    private Position pos;

    InteractableElement(Position pos){
        this.pos = pos;
    }

    public abstract void interact(PlayerModel player) throws HealthOVF, HungerRestored, HungerOVF, ThirstRestored, ThirstOVF;

    public Position getPos() {
        return pos;
    }


}
