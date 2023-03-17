package game;

import javax.swing.Icon;

public class Pos {
    int row;
    int col;
    String name;
    Icon img;
    protected Pos(int x,int y){
        row = x;
        col = y;
    }

    protected Pos(int x,int y,String n){
        row = x;
        col = y;
        name = n;
    }

    protected Pos(int x,int y,Icon icon){
        row = x; 
        col = y;
        img = icon;
    }

    @Override public String toString(){
        return String.format("(%d,%d)",row,col);
    }
    
}
