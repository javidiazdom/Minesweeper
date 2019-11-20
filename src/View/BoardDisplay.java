/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.scene.layout.GridPane;
import Model.SquareArray;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 *
 * @author javidiazdom
 */
public class BoardDisplay extends GridPane {
    
    public BoardDisplay () {
        for (int i = 0; i < 16 ; i++) {
            for (int j = 0; j < 16; j++) {
                SquareDisplay square = new SquareDisplay();
                add(square, i, j);
            }
        }
    }
    
    public void reset () {
        for (Node n : this.getChildren()) {
            Pane p = (Pane) n;
            p.getChildren().clear();
            n.setId("unclickedCell");
        }
    }
    
}
