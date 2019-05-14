package com.lpoo_32.model;

public class DoorModel extends InteractableElement{

    public DoorModel(Position pos) {
        super(pos);
    }

    @Override
    public boolean interact(PlayerModel player) {
        return true;
    }
}
