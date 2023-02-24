package src.game;
import src.game.gamesrc.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game extends JPanel implements ActionListener{
    private JPanel[][] scene = new JPanel[40][60];
    private char command;
    private Fruit fruit = new Fruit(scene);
    private Snake snake = new Snake(fruit,scene);
    private int state = 0;

    Timer t = new Timer(100, this);
    public Game(){
        setLayout(new GridLayout(40,60));
        addKeyListener(new KeyboardGame());
        GameComponent();
        setFocusable(true);
        t.start();
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
    }

    @Override public void actionPerformed(ActionEvent ev){
        if(state == 60){
            state = 0;
            fruit.setPosApple();
        }
        state++;
        snake.move(command);
    }

    private class KeyboardGame extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int keyPress = e.getKeyCode();
            if(keyPress == KeyEvent.VK_W && command != 's'){
                command = 'w';
            }else if(keyPress == KeyEvent.VK_S && command != 'w'){
                command = 's';
            }else if(keyPress == KeyEvent.VK_A && command != 'd'){
                command = 'a';
            }else if(keyPress == KeyEvent.VK_D && command != 'a'){
                command = 'd';
            }
        }
    }

    public static void main(String[] args) {
        JFrame x = new JFrame();
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setSize(800,500);
        x.add(new Game());
        x.setVisible(true);
    }
}
