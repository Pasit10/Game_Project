import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Game extends JFrame{
    private JPanel[][] scene = new JPanel[100][100];
    private ArrayList<snakeposXY> snake = new ArrayList<>();
    private char command;
    private boolean canbrake;
    Game(){
        setSize(1000,1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(100,100));
        GameComponent();
        setVisible(true);
    }

    private void GameComponent(){
        snake.add(new snakeposXY(scene[20][50]));
        for(int i = 0;i < scene.length;i++){
            for(int j = 0;j < scene[i].length;j++){
                scene[i][j] = new JPanel();
                scene[i][j].setSize(new Dimension(15, 15));
                scene[i][j].setBackground(Color.black);
                add(scene[i][j]);
            }
        }
    }

    private void move(char command){
        while(true){
            for(int i = 0;i < snake.size();i++){
                
            }
            switch(command){
                case 'w' :
                    
            }
            if(canbrake){
                break;
            }
        }
    }

    private class AddKeyboard implements KeyListener{
        @Override public void keyPressed(KeyEvent e){
            int keyPress = e.getKeyCode();
            switch(keyPress){
                case KeyEvent.VK_UP: command = 'w'; break;
                case KeyEvent.VK_DOWN: command = 's'; break;
                case KeyEvent.VK_LEFT: command = 'a'; break;
                case KeyEvent.VK_RIGHT: command = 'd'; break;
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }

    private class snakeposXY{
        JPanel pos;
        snakeposXY(JPanel x){
            pos = x;
        }
    }

    public static void main(String[] args){
        new Game();
    }
}