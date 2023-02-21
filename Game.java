import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Game extends JFrame implements KeyListener{
    private JPanel[][] scene = new JPanel[80][80];
    private ArrayList<snakeposXY> snake = new ArrayList<>();
    private char command;
    private boolean canbrake;
    Game(){
        setSize(1000,1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(80,80));
        addKeyListener(this);
        GameComponent();
        setVisible(true);
    }

    private void GameComponent(){
        for(int i = 0;i < scene.length;i++){
            for(int j = 0;j < scene[i].length;j++){
                scene[i][j] = new JPanel();
                scene[i][j].setSize(new Dimension(15, 15));
                scene[i][j].setBackground(Color.black);
                add(scene[i][j]);
            }
        }
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
        snake.add(new snakeposXY(20,50,scene[20][50]));
    }

    private void move(char command){
        //int x = 1;
        //while(true){
            JPanel snakeTail = snake.get(snake.size() - 1).pos;
            for(int j = snake.size() - 1; j > 0;j--){
                snake.get(j).row = snake.get(j - 1).row;
                snake.get(j).col = snake.get(j - 1).col;
                snake.get(j).pos = snake.get(j - 1).pos;
            }
            if(snake.get(0).row - 1 < 0){
                snake.get(0).row = scene.length;
            }
            if(snake.get(0).col - 1 < 0){
                snake.get(0).col = scene[0].length;
            }
            switch(command){
                case 'w' :
                    snake.get(0).pos = scene[(snake.get(0).row - 1) % scene.length][snake.get(0).col];
                    snake.get(0).row = (snake.get(0).row - 1) % scene.length;
                    break;
                case 's':
                    snake.get(0).pos = scene[(snake.get(0).row + 1) % scene.length][snake.get(0).col];
                    snake.get(0).row = (snake.get(0).row + 1) % scene.length;
                    break;
                case 'a':
                    System.out.println(snake);
                    snake.get(0).pos = scene[snake.get(0).row % scene.length][((snake.get(0).col - 1)) % scene[0].length];
                    snake.get(0).col = (snake.get(0).col - 1) % scene[0].length;
                    break;
                case 'd':
                    snake.get(0).pos = scene[snake.get(0).row % scene.length][(snake.get(0).col + 1) % scene[0].length];
                    snake.get(0).col = (snake.get(0).col + 1) % scene[0].length;
                    break;
            }
            System.out.println(snake.get(0));
            snake.get(0).pos.setBackground(Color.green);
            snakeTail.setBackground(Color.BLACK);
            System.out.println(snake);
            // if(canbrake){
            //     break;
            // }
            //x--;
        //}
    }

    // -------------- KeyListener --------------- //
    @Override public void keyPressed(KeyEvent e){
        int keyPress = e.getKeyCode();
        switch(keyPress){
            case KeyEvent.VK_W: command = 'w';break;
            case KeyEvent.VK_S: command = 's';break;
            case KeyEvent.VK_A: command = 'a';break;
            case KeyEvent.VK_D: command = 'd'; break;
        }
        System.out.println(command);
        move(command);
    }
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
     // -------------- KeyListener --------------- //

    private class snakeposXY{
        int row , col;
        JPanel pos;
        snakeposXY(int x,int y,JPanel z){
            this.row = x; this.col = y;
            pos = z;
        }
        @Override public String toString(){
            return String.format("(%d,%d)",row,col); 
        }
    }

    public static void main(String[] args){
        new Game();
    }
}