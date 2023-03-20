package game;

import javax.swing.*;
import src.CatGame;

public class gameframe extends JFrame{
    private JLabel score;
    private static final int WIDTH = 1220;
    private static final int HEIGHT = 750;
    private Game g;
    CatGame home;

    public gameframe(CatGame h){
        home = h;
        score = new JLabel("Score : ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        g = new Game(score,this);
        g.setBounds(0, 30, 1220, 700);
        score.setBounds(550, 10, 100, 20);
        add(g);
        add(score);
        setVisible(true);
    }

    protected void setVisMain(){
        home.setVisible(true);
    }
}
