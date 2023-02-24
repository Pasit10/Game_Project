package src.game.gamesrc;

import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class Fruit {
    private Snake snake;
    private JPanel[][] p;
    private ArrayList<FruitPos> AllFruit = new ArrayList<>();
    private Random rn = new Random();
    public Fruit(JPanel[][] p){
        this.p = p;
    }

    public void setPosApple(){
        int x = rn.nextInt(p.length) ,y = rn.nextInt(p[0].length);
        AllFruit.add(new FruitPos(x, y));
        p[x][y].setBackground(Color.YELLOW);
        System.out.println(AllFruit);
    }

    public boolean CheckHitSnake(int x,int y){
        for(int i = 0;i < AllFruit.size();i++){
            if(AllFruit.get(i).row == x && AllFruit.get(i).col == y){
                AllFruit.remove(i);
                System.out.println(AllFruit);
                return true;
            }
        }
        return false;
    }
    private class FruitPos{
        int row;
        int col;
        FruitPos(int x,int y){
            row = x; col = y;
        }
        @Override public String toString(){
            return String.format("(%d,%d)",row,col);
        }
    }
}
