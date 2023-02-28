package src.game;

class Pos {
    int row;
    int col;
    Pos(int x,int y){
        row = x; 
        col = y;
    }

    @Override public String toString(){
        return String.format("(%d,%d)",row,col);
    }
}
