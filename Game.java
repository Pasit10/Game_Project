import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener{
    private JPanel[][] scene = new JPanel[80][80];
    private ArrayList<snakeposXY> snake = new ArrayList<>();
    private char command = 'd';
    Timer t = new Timer(100, this);
    Game(){
        setLayout(new GridLayout(80,80));
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
        // ------------------ TEST ------------------------//
        for(int i = 0;i < 20;i++){
            snake.add(new snakeposXY(10,10));
        }
         // ------------------ TEST ------------------------//
    }

    private void move(char command){
        JPanel snakeTail = snake.get(snake.size() - 1).pos;
        for(int j = snake.size() - 1; j > 0;j--){
            snake.get(j).row = snake.get(j - 1).row;
            snake.get(j).col = snake.get(j - 1).col;
            snake.get(j).pos = snake.get(j - 1).pos;
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
        snake.get(0).pos = scene[(snake.get(0).row) % scene.length][snake.get(0).col];
        snake.get(0).pos.setBackground(Color.green);
        snakeTail.setBackground(Color.BLACK);
    }

    @Override public void actionPerformed(ActionEvent ev){
        move(command);
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

    private class snakeposXY{
        int row , col;
        JPanel pos;
        snakeposXY(int x,int y){
            this.row = x; this.col = y;
            pos = scene[x][y];
        }
        @Override public String toString(){
            return String.format("(%d,%d)",row,col); 
        }
    }

    public static void main(String[] args) {
        JFrame x = new JFrame();
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setSize(1000,1000);
        x.add(new Game());
        x.setVisible(true);
    }
}