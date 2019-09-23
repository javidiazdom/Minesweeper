/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


/**
 *
 * @author javid
 */
public class Counter extends Pane {
    private final Label backLabel;
    private Label flagsLabel;
    
    public Counter () {
        setId("timer");
        setLayoutX(30.00);
        setLayoutY(30.00);
        backLabel = new Label("88");
        backLabel.setId("numbers-back");
        this.getChildren().add(backLabel);
        backLabel.setTranslateY(-3.00);
        flagsLabel = new Label("00");
        flagsLabel.setId("numbers-front");
        this.getChildren().add(flagsLabel);
        flagsLabel.setTranslateY(-3.00);
        
    }
    
    public void set(int nMines) {
        if (nMines >= 0) {
            flagsLabel.setText(String.format("%02d", nMines));
        }
    }
}
