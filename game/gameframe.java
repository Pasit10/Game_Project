package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import src.SnakeGame;

public class gameframe extends JFrame{
    private SnakeGame home;
    private JPanel Top;

    public gameframe(SnakeGame h){
        home = h;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(1920, 1080);
        //setSize(1000, 1000);
        setVisible(true);
        PageCommonent();
        add(new Game());
    }

    private void PageCommonent(){
        Top = new JPanel();
        Top.setPreferredSize(new Dimension(1920,80));
        Top.setBackground(Color.RED);
        add(Top);
    }
}
