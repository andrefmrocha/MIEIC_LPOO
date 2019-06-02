package com.lpoo_32.view;

import com.lpoo_32.controller.GameController;
import com.lpoo_32.exceptions.OutOfBoundaries;
import com.lpoo_32.model.Elements;
import com.lpoo_32.model.MonsterModel;
import com.lpoo_32.model.PlayerModel;
import com.lpoo_32.model.Position;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


public class MenuSwingGUI extends JFrame {


    private JPanel root;
    private Selector selector;
    private Options options = new Options();
    private Image image;
    private Graphics buffer;

    public void draw(){
        buffer.clearRect(0, 0, GameSwing.ScreenWidth, GameSwing.ScreenHeight);
        selector.drawSwing(buffer);
        options.drawSwing(buffer);
        getGraphics().drawImage(image, 0, 0, null);
    }


    public MenuSwingGUI(Selector selector)
    {
        this.selector = selector;
        this.root = new JPanel();
        this.setVisible(true);
        setTitle("Menu");
        add(root);
        setSize(GameSwing.ScreenWidth,    GameSwing.ScreenHeight);
        image = createImage(GameSwing.ScreenWidth, GameSwing.ScreenHeight);
        buffer = image.getGraphics();
        this.addKeyListener(new MenuSwingKeyboard(this.selector));
    }



}
