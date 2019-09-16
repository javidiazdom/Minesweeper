package minesweeper.grid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.GridPane;
import javafx.fxml.*;
import java.util.Random;

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
        setMinHeight(400.0);
        setMinWidth(400.0);
        setLayoutX(21.0);
        setLayoutY(90.00);
        setId("square-array");
        shuffle();
    }
    
    @Override
    public void initialize (URL ur, ResourceBundle rb) {
        
    }
    
    protected void shuffle () {
        squares = new Square[size_x][size_y];
        for (int i = 0; i<16;i++) {
            for (int j = 0; j<16; j++) {
                squares[i][j] = new Square(i,j,this);
                add(squares[i][j],i,j);
            }
        }
        
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
    }
    
    /*
    
    */
    public int getNMines () {
        return nMines;
    }
    
    public void handleClick (Square clicked) {
        if (clicked.check()) {
            //logic of unveiling mines
        } else {
            //logic of ending game
        }
    }
    
    protected void addFlag() {
        flags++;
    }
    
    public int getFlags() {
        return flags;
    }
}
