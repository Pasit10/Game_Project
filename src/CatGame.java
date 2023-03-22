package src;

//package SnakeGame;

import javax.swing.*;

public class CatGame extends JFrame{
    Homepage Home;
    playmusic Sound = new playmusic();
    
    public CatGame() {
        Home = new Homepage(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        add(Home);   
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        Sound.Playmusic("Sound/Nyan-Cat.wav");
    }
}