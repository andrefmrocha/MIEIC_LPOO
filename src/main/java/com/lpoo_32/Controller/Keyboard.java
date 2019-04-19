package com.lpoo_32.Controller;

import java.io.IOException;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.lpoo_32.exceptions.ScreenClose;
import com.lpoo_32.exceptions.StatusOverflow;
import com.lpoo_32.model.Elements;
import com.lpoo_32.model.PlayerModel;
import com.lpoo_32.model.Position;
import com.lpoo_32.model.SpikesModel;

public class Keyboard
{
    private PlayerModel player;
    private Elements elements;

    public Keyboard(PlayerModel player, Elements elements)
    {
        this.player = player;
        this.elements = elements;
    }

    public void processKey(Screen screen) throws IOException, ScreenClose, StatusOverflow {

        KeyStroke key;
        key = screen.pollInput();
        SpikesModel spikes = new SpikesModel(10, null);
        if(key != null){
            switch (key.getKeyType()) {
                case ArrowUp:
                    player.moveUp();
                    break;
                case ArrowDown:
                    player.moveDown();
                    break;
                case ArrowLeft:
                    player.moveLeft();
                    break;
                case ArrowRight:
                    player.moveRight();
                    break;
                case Character:
                    switch (key.getCharacter()){
                        case 'q':
                            throw new ScreenClose();
                        case 'p':
                            spikes.interact(player);
                            break;
                        case 'h':
                            //TODO: How to proceed with this?
                            System.out.println("Open help Menu");
                            break;

                    }
            }
        }
    }

    /*
    public boolean canMove(Position position)
    {

    }*/

}
