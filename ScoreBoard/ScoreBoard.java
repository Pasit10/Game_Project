package ScoreBoard;
import src.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ScoreBoard extends JFrame{
    private ArrayList<String> name = new ArrayList<>();
    private CatGame game;
    public ScoreBoard(CatGame cg){
        game = cg;
    }

    private void getData(){
        try(Scanner input = new Scanner(Paths.get("ScoreBoard/score.csv"))){
            while(input.hasNext()){
                String[] info = input.nextLine().split(",");
                name.add(info[0] + " " + info[1]);
            }
        }catch(IOException io){
            System.out.println("FileNotFound");
        }
    }

    private void PrintData(){

    }
}