/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Polygon;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

/**
 *
 * @author javidiazdom
 */
public class FXML_IndexController implements Initializable {
    
    @FXML
    private Polygon triangle_gray;
    @FXML
    private Polygon triangle_white;
    @FXML
    private Polygon rectangle1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeStyle();
    }    
    
    
    private void initializeStyle() {
        triangle_gray.setFill(Color.GREY);
        triangle_gray.getPoints().addAll(new Double[]{
            440.0, 10.0,
            440.0, 590.0,
            10.0, 590.0 });
        triangle_white.getPoints().addAll(new Double[]{
           10.0,10.0,
           10.0,590.0,
           440.0,10.0
        });
        triangle_white.setFill(Color.WHITE);
        rectangle1.getPoints().addAll(new Double[]{
            13.00,13.00,
            13.00,587.00,
            437.00,587.00,
            437.00,13.00
        });
    }
}
