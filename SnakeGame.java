//package SnakeGame;

import javax.swing.*;
import java.awt.*;
import src.*;

public class SnakeGame extends JFrame{

    Game game;
    PanelSnake panels;

    
    public SnakeGame() {
        panels = new PanelSnake();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.add(panels);   
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // private void detailBoard(){
        // }
        
    public static void main(String[] args) {
        new SnakeGame();
    }
}