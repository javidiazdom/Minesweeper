package minesweeper.grid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.Region;
import javafx.fxml.*;
import java.util.Random;

/**
 *
 * @author javid
 */
public class SquareArray extends Region implements Initializable{
    
    private Square[][] squares;
    
    public SquareArray () {
        setMinHeight(509.0);
        setMinWidth(408.0);
        setLayoutX(21.0);
        setLayoutY(70.00);
        setStyle("-fx-background-color: #d1d1d1;-fx-border-width: 3; -fx-border-color: grey white white grey;");
    }
    
    @Override
    public void initialize (URL ur, ResourceBundle rb) {
        Random r = new Random();
        shuffle(r.nextInt());
    }
    
    protected void shuffle (double seed) {
        squares = new Square[16][16];
        for () {
            
        }
    }
}
