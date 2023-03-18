package game;

import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class Foods {
    private JLabel[][] p;
    private ArrayList<Pos> AllFruit = new ArrayList<>();
    private Icon commonfish = new ImageIcon("IMG/Fish20.png");
    private Icon goldenfish = new ImageIcon("game/IMGFORGAME/FishGold.png");
    private Random rn = new Random();
    protected Foods(JLabel[][] p){
        this.p = p;
    }

    private CAT snake;

    protected void setSnake(CAT sn){
        snake = sn;
    }

    protected void setPosCommonFish(){
        if(AllFruit.size() < 10){
            int x = rn.nextInt(p.length) ,y = rn.nextInt(p[0].length);
            if(Rock.AllRock.contains(new Pos(x,y))){
                setPosCommonFish();
            }
            AllFruit.add(new Pos(x, y,"commonfish"));
            p[x][y].setIcon(commonfish);
        }
        System.out.println(AllFruit);
    }

    protected void setPosGoldenFish(){
        if(AllFruit.size() < 10){
            int x = rn.nextInt(p.length) ,y = rn.nextInt(p[0].length);
            if(Rock.AllRock.contains(new Pos(x,y))){
                setPosCommonFish();
            }
            AllFruit.add(new Pos(x, y,"goldenfish"));
            p[x][y].setIcon(goldenfish);
        }
    }

    protected boolean CheckHitSnake(int x,int y){
        for(int i = 0;i < AllFruit.size();i++){
            if(AllFruit.get(i).row == x && AllFruit.get(i).col == y){
                if(AllFruit.get(i).name.equals("commonfish")){
                    snake.addTail();
                }else if(AllFruit.get(i).name.equals("goldenfish")){
                    snake.addTail();
                    snake.addTail();
                }
                AllFruit.remove(i);
            }
        }
        return false;
    }
}
