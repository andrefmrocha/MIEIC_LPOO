import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.lpoo_32.controller.GameController;
import com.lpoo_32.exceptions.OutOfBoundaries;
import com.lpoo_32.model.Elements;
import com.lpoo_32.model.PlayerModel;
import com.lpoo_32.model.Position;
import com.lpoo_32.view.*;
import com.lpoo_32.view.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws OutOfBoundaries, IOException {
        if(args[0].contentEquals("lanterna")){
            try{
                Menu menu = new Menu(new DefaultTerminalFactory().createTerminal());
                menu.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Elements elements = new Elements();
            PlayerModel model = new PlayerModel(new Position(2,2, Game.width/4, Game.height/4, 0));
            JFrame frame = new JFrame();
            GameController game = new GameController(
                    elements,
                    model,
                    new GameSwing(frame, model, elements)
            );
            frame.addKeyListener(new SwingKeyboard(game));
            game.run();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            System.out.println("Stopping game");
        }

    }
}
