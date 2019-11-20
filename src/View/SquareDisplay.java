/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.scene.layout.Pane;

/**
 *
 * @author javidiazdom
 */
public class SquareDisplay extends Pane {
    public SquareDisplay () {
        setId("unclickedCell");
        setMinHeight(25.00);
        setMinWidth(25.00);
    }
    
    public void changeId(String id) {
        setId(id);
    }
}
