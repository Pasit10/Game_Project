import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake{
    private JLabel[][] scene;
    private Fruit fruit;
    private Icon Headup = new ImageIcon("game/IMGFORGAME/CatUp.png");
    private Icon Headdown = new ImageIcon("game/IMGFORGAME/CatDown.png");
    private Icon Headleft = new ImageIcon("game/IMGFORGAME/CatLeft.png");
    private Icon Headright = new ImageIcon("game/IMGFORGAME/CatRight.png");
    private Icon body = new ImageIcon("game/IMGFORGAME/Rainbow-3 redup.png");
    private Icon BodyredUp = new ImageIcon("game/IMGFORGAME/Rainbow-3 redup.png");
    private Icon BodyredDown = new ImageIcon("game/IMGFORGAME/Rainbow-3 reddown.png");
    private Icon Bodyupleft = new ImageIcon("game/IMGFORGAME/Rian-turn-1-1.png");
    private Icon Bodyupright = new ImageIcon("game/IMGFORGAME/Rian-turn-1-2.png");
    private Icon Bodydownleft = new ImageIcon("game/IMGFORGAME/Rian-turn-1-3.png");
    private Icon Bodydownright = new ImageIcon("game/IMGFORGAME/Rian-turn-1-4.png");
    protected ArrayList<Pos> snake = new ArrayList<>();

    protected Snake(Fruit f,JLabel[][] s){
        fruit = f;
        scene = s;
        Random rn = new Random();
        int x = rn.nextInt(scene.length);
        int y = rn.nextInt(scene[0].length);
        snake.add(new Pos(x, y));
        scene[x][y].setIcon(Headright);
    }

    private void addTail(){
        snake.add(new Pos(snake.get(snake.size() - 1).row, snake.get(snake.size() - 1).col));
        System.out.println(snake.size());
    }

    protected void move(char command){
        Icon Head = null;
        int x = snake.get(snake.size() - 1).row;
        int y = snake.get(snake.size() - 1).col;
        scene[x][y].setIcon(null);
        for(int j = snake.size() - 1; j > 0;j--){
            snake.get(j).row = snake.get(j - 1).row;
            snake.get(j).col = snake.get(j - 1).col;
            scene[snake.get(j).row][snake.get(j).col].setIcon(body);
        }
        // --------------- set Pos --------------- //
        try{
            switch(command){
                case 'w' :
                    snake.get(0).row = (snake.get(0).row - 1);
                    Head = Headup;
                    break;
                case 's':
                    snake.get(0).row = (snake.get(0).row + 1);
                    Head = Headdown;
                    break;
                case 'a':
                    snake.get(0).col = (snake.get(0).col - 1); 
                    Head = Headleft;
                    break;
                case 'd':
                    snake.get(0).col = (snake.get(0).col + 1);
                    Head = Headright;
                    break;
            }
            scene[(snake.get(0).row)][snake.get(0).col].setIcon(Head);
        }catch(ArrayIndexOutOfBoundsException ArrOutOfbound){
            System.exit(1);
        }
        checkHitBody(); 
        if(fruit.CheckHitSnake(snake.get(0).row,snake.get(0).col)) addTail();
    }

    private void checkHitBody(){
        for(int i = 1;i < snake.size();i++){
            if(snake.get(i).row == snake.get(0).row && snake.get(i).col == snake.get(0).col){
                System.exit(1);
            }
        }
    }
}