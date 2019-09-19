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
    private final int nTotalMines=10;
    
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
            if (!squares[i][j].check()) {
                squares[i][j].setMine();
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
        if (!clicked.check()) {
            unveilSquare(clicked);
        } else {
            unveilMines();
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
    
    private int unveilSquare (Square current) {
        int r = 0;
        for (int i = current.getX()-1; i <= current.getX()+1; i++) {
            for (int j = current.getY()-1;j <= current.getY()+1; j++) {
                if (i>size_x || i < 0 || j > size_y || j < 0) {
                        continue;
                    } else {
                    if (squares[i][j].isMine()) {
                        r++;
                    }
                }
            }
        }
        current.setN(r);
        return r;
    }
    
}
