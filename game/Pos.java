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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + row;
        result = prime * result + col;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pos other = (Pos) obj;
        if (row != other.row)
            return false;
        if (col != other.col)
            return false;
        return true;
    }
}
