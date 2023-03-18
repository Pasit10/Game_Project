package game;
import java.awt.*;
import javax.swing.*;

import src.SnakeGame;

public class gameframe extends JFrame{
    private JLabel score;
    private SnakeGame home;
    private Game g;

    public gameframe(SnakeGame h){
        home = h;
        score = new JLabel("Score : ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setLayout(new FlowLayout());
        setSize(1200, 750);
        setVisible(true);
        g = new Game(score);
        g.setBounds(0, 30, 1200, 700);
        score.setBounds(550, 10, 100, 10);
        add(g);
        add(score);
    }

    protected void setVisMain(){
        home.setVisible(true);
    }
}
