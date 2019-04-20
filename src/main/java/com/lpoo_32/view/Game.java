package com.lpoo_32.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.lpoo_32.controller.Keyboard;
import com.lpoo_32.exceptions.ScreenClose;
import com.lpoo_32.exceptions.StatusOverflow;
import com.lpoo_32.model.PlayerModel;
import com.lpoo_32.model.Position;
import com.lpoo_32.model.*;

import java.io.IOException;


public class Game extends Display{

    private TextGraphics graphics;
    private Keyboard keyboard;
    private PlayerView player;
    public static final int width = 47;
    public static final int height = 58;
    private static final int frameRate = 60;

    Game(Screen screen) throws IOException {
        super(screen);
        this.setInitialProps();
        this.graphics =  this.screen.newTextGraphics();

        //probably needs to clean up
        this.keyboard = new Keyboard(this.player.getPlayer(),this.elements);


    }

    public void run() throws IOException {

        this.screen.clear();
        draw();
        this.screen.refresh();

        //isto parece shady; ter um ciclo infinito a para com uma exceçao
        int time = 0;
        try {
            while (true) {
                this.screen.clear();
                keyboard.processKey(screen);
                draw();
                this.screen.refresh();
                Thread.sleep(1000/ frameRate);
                time++;
                if(time % 3600 == 0)
                    this.player.getPlayer().getWater().decreaseValue(5);

                if(time % (5400.0) == 0)
                    this.player.getPlayer().getFood().decreaseValue(5);

            }
        }
        catch(ScreenClose e)
        {
            System.out.println("Player pressed Q, back to Main Menu....");
        } catch (InterruptedException statusOverflow) {
            statusOverflow.printStackTrace();
        }
        catch (StatusOverflow statusOverflow){
            System.out.println("You lose! Back to Main Menu....");
        }
    }

    @Override
    public void draw() throws IOException {


        graphics.setBackgroundColor(TextColor.Factory.fromString("#48D1CC"));
        graphics.fillRectangle(new TerminalPosition(0, 0),
                                new TerminalSize(ScreenSize.instance().getColumn(60),
                                ScreenSize.instance().getRows(50)), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));

        /*graphics.putString(new TerminalPosition(ScreenSize.instance().getColumn(20),
                            ScreenSize.instance().getRows(20)), "@");*/

        for(ElementView drawable: this.props)
            drawable.draw(graphics);



    }

    private void setInitialProps(){

        InteractableElement food = new FoodModel(10,new Position(2,3));
        InteractableElement spike = new SpikesModel(30,new Position(4,4));
        InteractableElement spike2 = new SpikesModel(10,new Position(6,4));

        System.out.println("Meias");
        //TODO Add Actual Player model values to the Bars
        this.props.add(new FoodView((FoodModel) food));
        this.props.add(new SpikesView((SpikesModel) spike));
        this.props.add(new SpikesView((SpikesModel) spike2));

        this.elements.addElement(food);
        System.out.println("Elements has finished");
        this.elements.addElement(spike);
        this.elements.addElement(spike2);
        this.player = new PlayerView(new PlayerModel(new Position(2,2)));
        this.props.add(new StatusBar(player.getPlayer().getHealth(), "#990000", 10));
        this.props.add(new StatusBar(player.getPlayer().getFood(), "#3CB371", 14));
        this.props.add(new StatusBar(player.getPlayer().getFood(), "#87CEFA", 18));
        this.props.add(this.player);
        System.out.println("The end");

    }
}
