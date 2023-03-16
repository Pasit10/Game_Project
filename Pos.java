import javax.swing.Icon;

class Pos {
    int row;
    int col;
    Icon img;
    Pos(int x,int y){
        row = x; 
        col = y;
    }

    Pos(int x,int y,Icon icon){
        row = x;
        col = y;
        img = icon;
    }
    @Override public String toString(){
        return String.format("(%d,%d)",row,col);
    }
}
