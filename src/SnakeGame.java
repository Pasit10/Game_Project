package src;

//package SnakeGame;

import javax.swing.*;

public class SnakeGame extends JFrame{

    Game game;
    Homepage Home;
    playmusic Sound = new playmusic();
    
    public SnakeGame() {
        Home = new Homepage(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.add(Home);   
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Sound.Playmusic("Sound/Nyan-Cat.wav");
    }
           
    public static void main(String[] args) {
        new SnakeGame();
    }
}