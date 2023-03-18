package ScoerBorad;
import java.awt.TextField;
import java.io.IOException;
import java.nio.file.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddnametoScoreBorad extends JFrame{
    private JLabel gameOver;
    private JTextField addName;
    public AddnametoScoreBorad(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        AddnametoScoreBoradComponents();
        setLayout(null);
        setVisible(true);
    }

    private void AddnametoScoreBoradComponents(){
        gameOver = new JLabel("GameOver");
        gameOver.setBounds(375, 5, 200, 100);
        add(gameOver);
        addName = new JTextField();
        addName.setBounds(340, 200 , 150, 20);
        add(addName);
    }

    public static void main(String[] args){
        new AddnametoScoreBorad();
    }
}

