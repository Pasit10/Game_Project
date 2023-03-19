package ScoreBoard;
import src.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class ScoreBoard extends JFrame{
    private ArrayList<Person> allPersons = new ArrayList<>();
    private CatGame game;
    public ScoreBoard(CatGame cg){
        game = cg;
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
        for(Person i : allPersons){
            System.out.println(i.name + " " + i.score);
        }
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