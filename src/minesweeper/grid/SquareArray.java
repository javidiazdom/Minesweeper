package minesweeper.grid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.GridPane;
import javafx.fxml.*;
import java.util.Random;
import minesweeper.GameLogic;

/**
 *
 * @author javid
 */
public class SquareArray extends GridPane implements Initializable{
    
    private Square[][] squares;
    
    //Constants:
    private int flags;
    private int nMines=10;
    
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
        int m = 0;
        while(m < nMines) {
            Random r = new Random();
            int i = r.nextInt(size_x);
            int j = r.nextInt(size_y);
            if (!squares[i][j].check()) {
                squares[i][j].setMine();
                m++;
            }
        }
        System.out.println(this.hashCode());
    }
    
    public void reset () {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                squares[i][j].reset();
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
            //logic of unveiling mines
        } else {
            squares = null;
            System.out.println("check");
        }
    }
    
    protected void addFlag(int n) {
        flags+= n;
    }
    
    public int getFlags() {
        return flags;
    }
}
