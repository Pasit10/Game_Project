import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake{
    private JLabel[][] scene;
    private Fruit fruit;
    private Icon Head = new ImageIcon("orange600x600.jpg");;
    private Icon Body = new ImageIcon("Cat10-4.png");
    protected ArrayList<Pos> snake = new ArrayList<>();

    protected Snake(Fruit f,JLabel[][] s){
        fruit = f;
        scene = s;
        Random rn = new Random();
        int x = rn.nextInt(scene.length);
        int y = rn.nextInt(scene[0].length);
        snake.add(new Pos(x, y));
        snake.add(new Pos(x, y));
        scene[x][y].setIcon(Head);
    }

    private void addTail(){
        snake.add(new Pos(snake.get(snake.size() - 1).row, snake.get(snake.size() - 1).col));
        System.out.println(snake.size());
    }

    protected void move(char command){
        int x = snake.get(snake.size() - 1).row;
        int y = snake.get(snake.size() - 1).col;
        scene[x][y].setIcon(null);
        for(int j = snake.size() - 1; j > 0;j--){
            snake.get(j).row = snake.get(j - 1).row;
            snake.get(j).col = snake.get(j - 1).col;
            scene[snake.get(j).row][snake.get(j).col].setIcon(Body);;
        }
        // --------------- set Pos --------------- //
        try{
            switch(command){
                case 'w' :
                    snake.get(0).row = (snake.get(0).row - 1);
                    break;
                case 's':
                    snake.get(0).row = (snake.get(0).row + 1);
                    break;
                case 'a':
                    snake.get(0).col = (snake.get(0).col - 1); 
                    break;
                case 'd':
                    snake.get(0).col = (snake.get(0).col + 1);
                    break;
            }
            scene[(snake.get(0).row)][snake.get(0).col].setIcon(Head);;
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
                // for(int j = snake.size() - 1;j > i;j--){
                //     scene[snake.get(j).row][snake.get(j).col].setBackground(Color.BLACK);
                //     snake.remove(snake.size() - 1);
                // }
                // break;
            }
        }
    }
}