package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 500;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 120;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 3;
    int appleEaten = 0;
    int count = 90;
    ArrayList<Integer> allAppleX = new ArrayList<>();
    ArrayList<Integer> allAppleY = new ArrayList<>();
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    Image Head = new ImageIcon("IMG/Cat10.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        for(int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++){
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT); // grid x line
            g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
        }
        g.setColor(Color.red);
        for(int i = 0;i < allAppleX.size();i++){
            g.fillOval(allAppleX.get(i), allAppleY.get(i), UNIT_SIZE, UNIT_SIZE);
        }

        for(int i = 0; i < bodyParts; i++){
            if(i==0){
                g.drawImage(Head,x[i],y[i],UNIT_SIZE, UNIT_SIZE, null);
            }
            else{
                g.setColor(new Color(45,180,0));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }
    public void newApple(){
        if(allAppleX.size() > 5){
            return;
        }
        int appleX = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        int appleY = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        allAppleX.add(appleX);
        allAppleY.add(appleY);
    }
    public void move(){
        for(int i = bodyParts; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
            
        }
        switch(direction){
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }
    public void checkApple(){
        for(int i = 0;i < allAppleX.size();i++){
            if(allAppleX.get(i) == x[0] && allAppleY.get(i) == y[0]){
                appleEaten++;
                bodyParts++;
                newApple();
                allAppleX.remove(i);
                allAppleY.remove(i);
            }
        }
    }
    public void checkCollision(){
        // check head crash body
        for(int i = bodyParts; i > 0; i--){
            if((x[0] == x[i] && y[0] == y[i])){
                running = false;
            }
        }
        // check head crash left screen
        if(x[0] < 0){
            running = false;
        }
        // check head crash right screen
        if(x[0] > SCREEN_WIDTH){
            running = false;
        }
        // check head crash top screen
        if(y[0] < 0){
            running = false;
        }
        // check head crash bottom screen
        if(y[0] > SCREEN_HEIGHT){
            running = false;
        }
        if(running == false){
            gameOver();
            timer.stop();
        }
    }
    public void gameOver(){
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollision();
        }
        if(count <= 0){
            newApple();
            count = 90;
        }
        System.out.println(count);
        count--;
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter{
        //@Override
        public void keyPressed(KeyEvent e){
            int keyPress = e.getKeyCode();
            if((keyPress == KeyEvent.VK_W || keyPress == KeyEvent.VK_UP ) && direction != 'D'){
                direction = 'U';
            }else if((keyPress == KeyEvent.VK_S || keyPress == KeyEvent.VK_DOWN ) && direction != 'U'){
                direction = 'D';
            }else if((keyPress == KeyEvent.VK_A || keyPress == KeyEvent.VK_LEFT ) && direction != 'R'){
                direction = 'L';
            }else if((keyPress == KeyEvent.VK_D || keyPress == KeyEvent.VK_RIGHT ) && direction != 'L'){
                direction = 'R';
            }
        }
    }
    
}
