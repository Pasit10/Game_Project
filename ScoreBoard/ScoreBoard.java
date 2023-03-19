package ScoreBoard;
import src.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class ScoreBoard extends JFrame implements MouseListener{
    private ArrayList<Person> allPersons = new ArrayList<>();
    private CatGame game;
    private Font font = new Font("Lucida Console",Font.BOLD,40);
    private ImageIcon back = new ImageIcon(new ImageIcon("IMG/Arrow250.png").getImage());
    private JLabel btnback = new JLabel(back);

    public ScoreBoard(CatGame cg){
        game = cg;
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JLabel bgimage = new JLabel(new ImageIcon("IMG/nyancat500-background.jpg"));
        bgimage.setBounds(0, 0, 800, 500);
        scoreBoardcomponent();  
        this.add(bgimage);
        setVisible(true);
    }

    private void scoreBoardcomponent(){
        btnback.setBounds(0, 0, 100, 70);
        btnback.addMouseListener(this);
        add(btnback);
        JLabel title = new JLabel("Score Board");
        title.setFont(font);
        title.setBounds(250, 20, 300, 70);
        title.setForeground(Color.white);
        add(title);
        getData();
        PrintData();
    }

    private void getData(){
        try(Scanner input = new Scanner(Paths.get("ScoreBoard/score.csv"))){
            while(input.hasNext()){
                String[] info = input.nextLine().split(",");
                allPersons.add(new Person(info[0], Integer.parseInt(info[1])));   
            }
            Collections.sort(allPersons,new sortByScore());
            Collections.reverse(allPersons);
        }catch(IOException io){
            System.out.println("FileNotFound");
        }
    }

    private void PrintData(){
        Font font2 = new Font("Lucida Console",Font.PLAIN,30);
        JLabel headname = new JLabel("name");
        JLabel headscore = new JLabel("score");
        headname.setFont(font2);
        headscore.setFont(font2);
        headname.setBounds(240,100,100,70);
        headscore.setBounds(585, 100, 120, 70);
        headname.setForeground(Color.white);
        headscore.setForeground(Color.white);
        add(headname);
        add(headscore);
        int high = 160;
        for(int i = 0;i < allPersons.size();i++){
            if(i >= 4){
                break;
            }
            JLabel name = new JLabel((i + 1) + "  " + allPersons.get(i).name);
            JLabel score = new JLabel("" + allPersons.get(i).score);
            name.setFont(font2);
            score.setFont(font2);
            name.setBounds(120, high, 400, 70);
            score.setBounds(600, high,90 , 70);
            name.setForeground(Color.white);
            score.setForeground(Color.white);
            add(name);
            add(score);
            high += 75;
        }
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == btnback){
            setVisible(false);
            game.setVisible(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    private class sortByScore implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.score - o2.score;
        }
    }

    private class Person{
        String name;
        int score;
        Person(String n,int s){
            name = n;
            score = s;
        }
    }

    public static void main(String[] args) {
        new ScoreBoard(null);
    }
}