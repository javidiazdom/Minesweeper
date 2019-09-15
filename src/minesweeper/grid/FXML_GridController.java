package minesweeper.grid;

import java.util.ResourceBundle;
import javafx.fxml.*;
import java.net.URL;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 *
 * @author javidiazdom
 */
public class FXML_GridController implements Initializable {
    
    @FXML
    private SquareArray square_array = new SquareArray();
    
    @Override
    public void initialize (URL ur, ResourceBundle rb) {
        
    }
}
