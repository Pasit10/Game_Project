package game;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Rock {
    static ArrayList<Pos> AllRock = new ArrayList<>();
    static Random rn = new Random();
    //private Icon rock = new ImageIcon("IMG/stone20.png");
    private JLabel[][] scenes;
    Icon rock;

    public Rock(JLabel[][] scenes){
        this.scenes = scenes;
        setAllPosRock();
    }

    private void setAllPosRock(){
        for(int i = 0;i < 20;i++){
            int x = rn.nextInt(scenes.length);
            int y = rn.nextInt(scenes[1].length);
            if(AllRock.contains(new Pos(x, y))){
                System.out.println("jj");
                i --;
                continue;
            }
            AllRock.add(new Pos(x, y));
            if(Math.random() < 0.50){
                rock = new ImageIcon("IMG/stone225.png");
            }else{
                rock = new ImageIcon("IMG/stone20.png");
            }
            scenes[x][y].setIcon(rock);
        }
    }

}
