package minesweeper.grid;

import java.util.ResourceBundle;
import javafx.fxml.*;
import java.net.URL;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.GridPane;

/**
 *
 * @author javidiazdom
 */
public class FXML_GridController implements Initializable {
    
    @FXML
    private GridPane tabla;
    
    private SquareArray squares;
    
    @Override
    public void initialize (URL ur, ResourceBundle rb) {
        squares = new SquareArray();
    }
}
