package ScoreBoard;
import java.awt.TextField;
import java.io.IOException;
import java.nio.file.*;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.CatGame;

public class AddnametoScoreBoard extends JFrame implements ActionListener{
    private JLabel gameOver;
    private JButton next;
    private JLabel yourscore;
    private JTextField addName;
    private int score;
    private CatGame catgame;
    public AddnametoScoreBoard(int score,CatGame ct){
        catgame = ct;
        this.score = score;
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
        yourscore = new JLabel("Your Score : " + score);
        yourscore.setBounds(350, 35, 100, 100);
        add(yourscore);
        addName = new JTextField("Input Your Name");
        addName.setBounds(275, 200 ,250, 40);
        add(addName);
        next = new JButton("next");
        next.setBounds(325, 300, 150,50);
        add(next);
        next.addActionListener(this);
    }

    @Override public void actionPerformed(ActionEvent ev){
        if(ev.getSource() == next){
            addDatatocsv();
            setVisible(false);
            catgame.setVisible(true);
        }
    }

    private void addDatatocsv(){
        try{
            FileWriter csvWriter = new FileWriter("ScoreBoard/score.csv",true);
            csvWriter.append(addName.getText() + "," + score + "\n");

            csvWriter.flush();
            csvWriter.close();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}

