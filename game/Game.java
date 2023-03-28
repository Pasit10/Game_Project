package game;
import ScoreBoard.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Game extends JLabel implements ActionListener{
    private int speed = 140;
    private int x = 30;
    private int y = 60;
    private JLabel[][] snakescenes = new JLabel[x][y];
    private char command;
    private Foods fruit;
    private CAT snake;
    private int changeTimer = 0;
    boolean isPlaying = true;
    private gameframe gf;
    private JLabel score;

    private ArrayList<UFO> ufos = new ArrayList<>();

    Timer t = new Timer(speed, this);
    public Game(JLabel score,gameframe gf){
        this.gf = gf;
        this.score = score;
        setIcon(new ImageIcon("IMG/Black-Galaxy1080-background.jpg"));
        setOpaque(false);
        setSize(1200,700);
        setLayout(new GridLayout(x,y));
        addKeyListener(new KeyboardGame());
        GameComponent();
        new Rock(snakescenes);
        fruit = new Foods(snakescenes);
        snake = new CAT(fruit,snakescenes,this);
        setFocusable(true);
        fruit.setPosCommonFish();
        fruit.setPosGoldenFish();
        t.start();
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

    protected void setIsplay(){
        isPlaying = false;
    }

    @Override public void actionPerformed(ActionEvent ev){
        if(Math.random() > 0.6){
            fruit.setPosCommonFish();
        }
        if(Math.random() > 0.8){
            fruit.setPosGoldenFish();
        }
        if(Math.random() > 0.9){
            if(ufos.size() <= 5){
                ufos.add(new UFO(snakescenes, fruit));
            }
        }
        if(changeTimer >= 100 && speed > 50){
            changeTimer = 0;
            speed -= 5;
            t.setDelay(speed);
        }
        for(int i = 0;i < ufos.size();i++){
            if(ufos.get(i).getHitede()){
                ufos.remove(i);
            }
        }
        changeTimer++;
        snake.move(command);
        score.setText("Score : " + snake.getSnakelength());
        if(!isPlaying){
            ufos.clear();
            t.stop();
            new AddnametoScoreBoard(snake.getSnakelength(),gf.home);
            gf.setVisible(false);
            Rock.AllRock.clear();
        }
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
        }
    }
}
