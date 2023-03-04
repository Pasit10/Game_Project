package src.game;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Game extends JPanel implements ActionListener{
    private int speed = 150;
    private JPanel[][] scene = new JPanel[40][60];
    private char command;
    private Fruit fruit = new Fruit(scene);
    private Snake snake = new Snake(fruit,scene);
    private Random rn = new Random();
    private int state = 0;
    private int maxstate = rn.nextInt(60);
    private int changeTimer = 0;

    Timer t = new Timer(speed, this);
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
        fruit.setPosApple();
    }

    @Override public void actionPerformed(ActionEvent ev){
        if(state >= maxstate){
            state = 0;
            maxstate = rn.nextInt(60);
            fruit.setPosApple();
            System.out.println(maxstate);
        }
        if(changeTimer >= 100 && speed > 50){
            changeTimer = 0;
            speed -= 2;
            System.out.println(speed + " speed ");
            t.setDelay(speed);
        }
        state++;
        changeTimer++;
        System.out.println(changeTimer);
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
            }else if(keyPress == KeyEvent.VK_SHIFT){
                t.setDelay(1);
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
