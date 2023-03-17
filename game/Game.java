package game;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Game extends JPanel implements ActionListener{
    private JLabel SnakePart;
    private JLabel BackGroundPart;
    private int speed = 120;
    private int x = 40;
    private int y = 80;
    private JLabel[][] snakescenes = new JLabel[x][y];
    private char command;
    private Fruit fruit;
    private Snake snake;
    private Random rn = new Random();
    private int state = 0;
    private int maxstate = rn.nextInt(60);
    private int changeTimer = 0;

    Timer t = new Timer(speed, this);
    public Game(){
        setSize(1920,1000);
        SnakePart = new JLabel();
        SnakePart.setPreferredSize(new Dimension(1520, 690));
        SnakePart.setLayout(new GridLayout(x,y));
        addKeyListener(new KeyboardGame());
        GameComponent();
        fruit = new Fruit(snakescenes);
        snake = new Snake(fruit,snakescenes);
        setFocusable(true);
        setBackground(Color.BLACK);
        fruit.setPosApple();
        add(SnakePart);
    }

    private void GameComponent(){
        for(int i = 0;i < snakescenes.length;i++){
            for(int j = 0;j < snakescenes[i].length;j++){
                snakescenes[i][j] = new JLabel();
                snakescenes[i][j].setPreferredSize(new Dimension(20, 20));
                SnakePart.add(snakescenes[i][j]);
            }
        }
    }

    @Override public void actionPerformed(ActionEvent ev){
        if(state >= maxstate){
            state = 0;
            maxstate = rn.nextInt(60);
            fruit.setPosApple();
        }
        if(changeTimer >= 100 && speed > 50){
            changeTimer = 0;
            speed -= 2;
            t.setDelay(speed);
        }
        state++;
        changeTimer++;
        snake.move(command);
    }

    private class KeyboardGame extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int keyPress = e.getKeyCode();
            if((keyPress == KeyEvent.VK_W || keyPress == KeyEvent.VK_UP ) && command != 's'){
                command = 'w';
            }else if((keyPress == KeyEvent.VK_S || keyPress == KeyEvent.VK_DOWN ) && command != 'w'){
                command = 's';
            }else if((keyPress == KeyEvent.VK_A || keyPress == KeyEvent.VK_LEFT ) && command != 'd'){
                command = 'a';
            }else if((keyPress == KeyEvent.VK_D || keyPress == KeyEvent.VK_RIGHT ) && command != 'a'){
                command = 'd';
            }
            t.start();
        }
    }
}
