package src.game.gamesrc;

import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class Fruit {
    private JPanel[][] p;
    private ArrayList<Pos> AllFruit = new ArrayList<>();
    private Random rn = new Random();
    public Fruit(JPanel[][] p){
        this.p = p;
    }

    public void setPosApple(){
        int x = rn.nextInt(p.length) ,y = rn.nextInt(p[0].length);
        AllFruit.add(new Pos(x, y));
        p[x][y].setBackground(Color.red);
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
}
