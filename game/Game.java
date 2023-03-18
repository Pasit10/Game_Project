package game;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Game extends JPanel implements ActionListener{
    private int speed = 140;
    private int x = 30;
    private int y = 60;
    private JLabel[][] snakescenes = new JLabel[x][y];
    private char command;
    private Fruit fruit;
    private Snake snake;
    private Random rn = new Random();
    private int state = 0;
    private int maxstate = rn.nextInt(40);
    private int changeTimer = 0;
    private int addGoldenfish = 3;

    Timer t = new Timer(speed, this);
    public Game(){
        setLayout(new GridLayout(x,y));
        //setLayout(null);
        addKeyListener(new KeyboardGame());
        GameComponent();
        fruit = new Fruit(snakescenes);
        snake = new Snake(fruit,snakescenes);
        setFocusable(true);
        setBackground(Color.BLACK);
        new Rock(snakescenes);
        fruit.setPosCommonFish();
        fruit.setPosGoldenFish();
    }

    private void GameComponent(){
        for(int i = 0;i < snakescenes.length;i++){
            for(int j = 0;j < snakescenes[i].length;j++){
                snakescenes[i][j] = new JLabel();
                snakescenes[i][j].setPreferredSize(new Dimension(20, 20));
                add(snakescenes[i][j]);
            }
        }
    }

    @Override public void actionPerformed(ActionEvent ev){
        if(state >= maxstate){
            state = 0;
            maxstate = rn.nextInt(60);
            fruit.setPosCommonFish();
            addGoldenfish--;
        }
        if(addGoldenfish <= 0){
            fruit.setPosGoldenFish();
            addGoldenfish = 3;
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
