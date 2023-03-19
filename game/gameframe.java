package game;
import java.awt.*;
import javax.swing.*;

import src.CatGame;

public class gameframe extends JFrame{
    private JLabel score;
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 750;
    private Game g;
    CatGame home;

    public gameframe(CatGame h){
        home = h;
        score = new JLabel("Score : ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setLayout(new FlowLayout());
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
        g = new Game(score,this);
        g.setBounds(0, 30, 1200, 700);
        score.setBounds(550, 10, 100, 10);
        add(g);
        add(score);
    }

    protected void setVisMain(){
        home.setVisible(true);
    }
}
