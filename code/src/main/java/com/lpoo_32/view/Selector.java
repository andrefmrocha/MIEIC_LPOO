package com.lpoo_32.view;

import com.googlecode.lanterna.graphics.TextGraphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

class Selector extends ElementView {
    private final MenuSwing menuSwing;
    private int index = 0;
    private BufferedImage image;

    Selector(MenuSwing menuSwing) {
        super();
        URL resource = getClass().getResource("/" + "cursor.png");
        try{
            this.image = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.menuSwing = menuSwing;
    }

    @Override
    void drawLanterna(TextGraphics graphics) {

    }

    @Override
    void drawSwing(Graphics graphics) {
        int y = 180;
        int x = 320;
        graphics.drawImage(image, x, y + index * 100, 30, 30, null);
    }

    public void moveUp() {
        if(this.index > 0){
            this.index--;
        }
    }

    public void moveDown() {
        if(this.index < 2){
            this.index++;
        }
    }

    public void enter() {
        switch (this.index){
            case 0:
                menuSwing.initiateGame();
                break;
            case 1:
                menuSwing.initiateHelp();
                break;
            case 2:
                menuSwing.stopGame();
                break;
        }
    }
}
