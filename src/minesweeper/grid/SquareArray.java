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
    private int nMinas=10;
    
    public SquareArray () {
        setMinHeight(509.0);
        setMinWidth(408.0);
        setLayoutX(21.0);
        setLayoutY(70.00);
        setStyle("-fx-background-color: #d1d1d1;-fx-border-width: 3; -fx-border-color: grey white white grey;");
    }
    
    @Override
    public void initialize (URL ur, ResourceBundle rb) {
        shuffle();
    }
    
    protected void shuffle () {
        squares = new Square[16][16];
        for (int i = 0; i<16;i++) {
            for (int j = 0; j<16; j++) {
                squares[i][j] = new Square(i,j);
                this.add(squares[i][j],i,j);
            }
        } 
    }
    
    public int getNMinas () {
        return nMinas;
    }
}
