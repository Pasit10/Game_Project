package src.game;
import src.game.gamesrc.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanal extends JPanel implements ActionListener{
    protected JPanel[][] scene = new JPanel[80][80];
    private char command = 'd';
    private Snake snake = new Snake(scene);
    Timer t = new Timer(100, this);
    public GamePanal(){
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
    }

    @Override public void actionPerformed(ActionEvent ev){
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
        x.setSize(1000,1000);
        x.add(new GamePanal());
        x.setVisible(true);
    }
}