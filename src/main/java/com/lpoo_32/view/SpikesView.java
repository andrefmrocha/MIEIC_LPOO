package com.lpoo_32.view;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.lpoo_32.model.FoodModel;
import com.lpoo_32.model.InteractableElement;
import com.lpoo_32.model.SpikesModel;

public class SpikesView implements ElementView {

    private SpikesModel spikes;

    public SpikesView(SpikesModel spikes){
        this.spikes = spikes;
    }

    @Override
    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#7CFC00"));

        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));

        graphics.fillRectangle(
                this.spikes.getPos().getTerminalPosition(),
                new TerminalSize(1, 1),
                Symbols.SPADES
        );
    }

    public SpikesModel getSpikes()
    {
        return spikes;
    }



}
