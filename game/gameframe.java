package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import src.SnakeGame;

public class gameframe extends JFrame{
    private SnakeGame home;

    public gameframe(SnakeGame h){
        home = h;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new FlowLayout());
        setBounds(0, 0, 100, 100);
        setSize(1920, 1080);
        setVisible(true);
        add(new Game());
    }

    protected void setVisMain(){
        home.setVisible(true);
    }
}
