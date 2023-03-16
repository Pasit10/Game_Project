//package SnakeGame;

import javax.swing.*;
import java.awt.*;
import src.*;

public class SnakeGame extends JFrame{

    Game game;
    Homepage Home;

    
    public SnakeGame() {
        Home = new Homepage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.add(Home);   
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
           
    public static void main(String[] args) {
        new SnakeGame();
    }
}