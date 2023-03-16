import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Game extends JPanel implements ActionListener{
    private int speed = 120;
    private int x = 40;
    private int y = 80;
    private JLabel[][] snakescenes = new JLabel[x][y];
    private JLabel[][] scenes = new JLabel[x][y];
    private char command;
    private Fruit fruit;
    private Snake snake;
    private Random rn = new Random();
    private int state = 0;
    private int maxstate = rn.nextInt(60);
    private int changeTimer = 0;

    Timer t = new Timer(speed, this);
    public Game(){
        setSize(800,500);
        setLayout(new GridLayout(x,y));
        addKeyListener(new KeyboardGame());
        BackgroundComponent();
        GameComponent();
        fruit = new Fruit(snakescenes);
        snake = new Snake(fruit,snakescenes);
        setFocusable(true);
        setBackground(Color.BLACK);
        fruit.setPosApple();
    }

    private void BackgroundComponent(){
        for(int i = 0;i < scenes.length;i++){
            for(int j = 0;j < scenes[0].length;j++){
                scenes[i][j] = new JLabel();
                scenes[i][j].setPreferredSize(new Dimension(30,30));
                scenes[i][j].setIcon(new ImageIcon("game/orange600x600.jpg"));
                add(scenes[i][j]);
            }
        }
    }

    private void GameComponent(){
        for(int i = 0;i < snakescenes.length;i++){
            for(int j = 0;j < snakescenes[i].length;j++){
                snakescenes[i][j] = new JLabel();
                snakescenes[i][j].setPreferredSize(new Dimension(30, 30));
                add(snakescenes[i][j]);
            }
        }
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
        System.out.println(changeTimer + "dd");
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

    public static void main(String[] args) {
        JFrame x = new JFrame();
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setSize(1920,1080);
        x.add(new Game());
        x.setVisible(true);
    }
}
