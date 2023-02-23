package src.game.gamesrc;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake{
    private JPanel[][] scene;
    private ArrayList<snakeposXY> snake = new ArrayList<>();

    public Snake(JPanel[][] s) {
        scene = s;
        Random rn = new Random();
        int x = rn.nextInt(scene.length);
        int y = rn.nextInt(scene[0].length);
        snake.add(new snakeposXY(x, y));
        snake.add(new snakeposXY(x, y));
        System.out.println(snake);
    }

    public void addTail(){
        snake.add(new snakeposXY(snake.get(snake.size() - 1).row, snake.get(snake.size() - 1).col));
    }

    public void move(char command){
        int x = snake.get(snake.size() - 1).row;
        int y = snake.get(snake.size() - 1).col;
        scene[x][y].setBackground(Color.BLACK);
        for(int j = snake.size() - 1; j > 0;j--){
            snake.get(j).row = snake.get(j - 1).row;
            snake.get(j).col = snake.get(j - 1).col;
        }
        // --------------- set Pos --------------- //
        if(snake.get(0).row - 1 < 0){
            snake.get(0).row = scene.length;
        }
        if(snake.get(0).col - 1 < 0){
            snake.get(0).col = scene[0].length;
        }
        switch(command){
            case 'w' :
                snake.get(0).row = (snake.get(0).row - 1) % scene.length;
                break;
            case 's':
                snake.get(0).row = (snake.get(0).row + 1) % scene.length;
                break;
            case 'a':
                snake.get(0).col = (snake.get(0).col - 1) % scene[0].length;
                break;
            case 'd':
                snake.get(0).col = (snake.get(0).col + 1) % scene[0].length;
                break;
        }
        scene[(snake.get(0).row) % scene.length][snake.get(0).col].setBackground(Color.GREEN);
    }

    private class snakeposXY{
        int row , col;
        snakeposXY(int x,int y){
            this.row = x; this.col = y;
        }
        @Override public String toString(){
            return String.format("(%d,%d)",row,col); 
        }
    }
}