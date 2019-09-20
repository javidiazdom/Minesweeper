package minesweeper.grid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.GridPane;
import javafx.fxml.*;
import java.util.Random;
import minesweeper.Minesweeper;

/**
 *
 * @author javid
 */
public class SquareArray extends GridPane implements Initializable{
    
    private class Coordinates {
        int x;
        int y;
        public Coordinates (int i, int j) {
            x = i;
            y = j;
        }
    }
    
    private final Square[][] squares;
    
    //Constants:
    private int flags;
    private final int nTotalMines=40;
    
    //Variables
    private int nMines;
    private Coordinates[] minesAt = new Coordinates[nTotalMines];
    
    //Size of the board
    int size_x = 16;
    int size_y = 16;
    
    public SquareArray () {
        setLayoutX(21.0);
        setLayoutY(90.00);
        setId("square-array");
        squares = new Square[size_x][size_y];
        for (int i = 0; i<16;i++) {
            for (int j = 0; j<16; j++) {
                squares[i][j] = new Square(i,j,this);
                add(squares[i][j],i,j);
            }
        }
    }
    
    @Override
    public void initialize (URL ur, ResourceBundle rb) {
        
    }
    
    public void shuffle () {
        nMines = 0;
        while(nMines < nTotalMines) {
            Random r = new Random();
            int i = r.nextInt(size_x);
            int j = r.nextInt(size_y);
            if (!squares[i][j].isMine()) {
                squares[i][j].setMine();
                for (int p = i-1; p<=i+1; p++){
                    for (int q = j-1; q<=j+1; q++){
                        if(p >= 0 && p < size_x && q >= 0 && q < size_y) {
                            squares[p][q].addN();
                        }
                    }
                }
                minesAt[nMines] = new Coordinates(i,j);
                nMines++;
            }
        }
    }
    
    public void reset () {
        nMines = 0;
        for (Square[] square1 : squares) {
            for (Square square : square1) {
                square.reset();
            }
        }
        shuffle();
    }
    
    /*
    
    */
    public int getNMines () {
        return nMines;
    }
    
    public void handleClick (Square clicked) {
        if (!clicked.isChecked()) {
            if (!clicked.check()) {
                unveilSquares(clicked);
            } else {
                unveilMines();
            }
        }
    }
    
    protected void addFlag(int n) {
        flags+= n;
    }
    
    public int getFlags() {
        return flags;
    }
    
    private void unveilMines () {
        for (Coordinates c : minesAt) {
            squares[c.x][c.y].check();
        }
    }
    
    private void unveilSquares (Square actual) {
        if (!actual.isChecked() && actual.setN()==0) {
            int x = actual.getX();
            int y = actual.getY();
            for (int i = x-1; i <=x+1; i++) {
                for ( int j = y-1; j<=y+1; j++) {
                    if (i == x && j == y) {
                    } else {
                        if (i >= 0 && i < size_x && j >= 0 && j < size_y) {
                            unveilSquares(squares[i][j]);
                        }
                    }
                }
            }
        }
    }
}
