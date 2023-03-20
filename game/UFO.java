package game;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

enum command{
    LEFT,RIGHT
}

public class UFO implements ActionListener{
    private JLabel[][] scenes;
    private Icon ufo = new ImageIcon("game/IMGFORGAME/CatRight.png");
    private command cd;
    private Timer t = new Timer(200, this);
    private Random rn = new Random();
    private int x;
    private int y;

    protected UFO(JLabel[][] s){
        scenes = s;
        if(Math.random() > 0.5){
            x = 0;
            cd = command.RIGHT;
        }else{
            x = scenes[0].length - 1;
            cd = command.LEFT;
        }
        y = rn.nextInt(scenes.length);
        if(Rock.AllY.contains(y)){
            System.out.println("Random โง่ๆ");
            return;
        }
        scenes[y][x].setIcon(ufo);
        t.start();
    }

    @Override public void actionPerformed(ActionEvent ev){
        try{
            scenes[y][x].setIcon(null);
            if(cd == command.LEFT){
                x--;
            }else if(cd == command.RIGHT){
                x++;
            }
            scenes[y][x].setIcon(ufo);
        }catch(Exception ex){
            t.stop();
        }
        System.out.println(x + " " + y + "rock");
    }
}
