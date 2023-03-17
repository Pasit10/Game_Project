package game;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake{
    private JLabel[][] scene;
    private Fruit fruit;
    private Icon Headup = new ImageIcon("game/IMGFORGAME/CatUp.png");
    private Icon Headdown = new ImageIcon("game/IMGFORGAME/CatDown.png");
    private Icon Headleft = new ImageIcon("game/IMGFORGAME/CatLeft.png");
    private Icon Headright = new ImageIcon("game/IMGFORGAME/CatRight.png");
    private Icon body = new ImageIcon("game/IMGFORGAME/body.png");
    private Icon BodyY = new ImageIcon("game/IMGFORGAME/body.png");
    private Icon bodyUpanddown = new ImageIcon("game/IMGFORGAME/body_up.png");
    private Icon Bodyupleft = new ImageIcon("game/IMGFORGAME/body_up_left.png");
    private Icon Bodyupright = new ImageIcon("game/IMGFORGAME/body_up_right.png");
    private Icon Bodydownleft = new ImageIcon("game/IMGFORGAME/body_down_left.png");
    private Icon Bodydownright = new ImageIcon("game/IMGFORGAME/body_down_right.png");
    protected ArrayList<Pos> snake = new ArrayList<>();
    private char Oldcommad;

    protected Snake(Fruit f,JLabel[][] s){
        fruit = f;
        scene = s;
        Random rn = new Random();
        int x = rn.nextInt(scene.length);
        int y = rn.nextInt(scene[0].length);
        snake.add(new Pos(x, y,Headright));
        scene[x][y].setIcon(Headright);
    }

    private void addTail(){
        snake.add(new Pos(snake.get(snake.size() - 1).row, snake.get(snake.size() - 1).col));
        System.out.println(snake.size());
    }

    protected void move(char command){
        int x = snake.get(snake.size() - 1).row;
        int y = snake.get(snake.size() - 1).col;
        scene[x][y].setIcon(null);
        for(int j = snake.size() - 1; j > 0;j--){
            snake.get(j).row = snake.get(j - 1).row;
            snake.get(j).col = snake.get(j - 1).col;
        }
        for(int i = snake.size() - 1; i > 1;i--){
            snake.get(i).img = snake.get(i - 1).img;
            scene[snake.get(i).row][snake.get(i).col].setIcon(snake.get(i).img);
        }
        // --------------- set Pos --------------- //
        try{
            switch(command){
                case 'w' :
                    snake.get(0).row = (snake.get(0).row - 1);
                    snake.get(0).img = Headup;
                    if(snake.size() > 1) body = checkTailUP();
                    break;
                case 's':
                    snake.get(0).row = (snake.get(0).row + 1);
                    snake.get(0).img = Headdown;
                    if(snake.size() > 1) body = checkTailDown();
                    break;
                case 'a':
                    snake.get(0).col = (snake.get(0).col - 1);
                    snake.get(0).img = Headleft;
                    if(snake.size() > 1) body = checkTailLeft();
                    break;
                case 'd':
                    snake.get(0).col = (snake.get(0).col + 1);
                    snake.get(0).img = Headright;
                    if(snake.size() > 1) body = checkTailRight();
                    break;
            }
            scene[(snake.get(0).row)][snake.get(0).col].setIcon(snake.get(0).img);;
        }catch(ArrayIndexOutOfBoundsException ArrOutOfbound){
            System.exit(1);
        }
        checkHitBody(); 
        if(fruit.CheckHitSnake(snake.get(0).row,snake.get(0).col)) addTail();
        if(Oldcommad == command){
            if(command == 'w' || command == 's')
                body = bodyUpanddown;
            else
                body = BodyY;
        }
        if(snake.size() > 1){
            snake.get(1).img = body;
            scene[snake.get(1).row][snake.get(1).col].setIcon(snake.get(1).img);
        }
        Oldcommad = command;
    }

    private Icon checkTailUP(){
        if(Oldcommad == 'a'){
            return Bodyupright;
        }
        return Bodyupleft;
    }

    private Icon checkTailDown(){
        if(Oldcommad == 'a'){
            return Bodydownright;
        }
        return Bodydownleft;
    }

    private Icon checkTailLeft(){
        if(Oldcommad == 'w'){
            return Bodydownleft;
        }
        return Bodyupleft;
    }

    private Icon checkTailRight(){
        if(Oldcommad == 'w'){
            return Bodydownright;
        }
        return Bodyupright;
    }

    private void checkHitBody(){
        for(int i = 1;i < snake.size();i++){
            if(snake.get(i).row == snake.get(0).row && snake.get(i).col == snake.get(0).col){
                System.exit(1);
            }
        }
    }
}
