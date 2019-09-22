/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import grid.SquareArray;
import javafx.scene.layout.Pane;
import timer.Timer;
import counter.Counter;

/**
 *
 * @author javidiazdom
 */
public class Minesweeper extends Application implements Initializable {
    
    @FXML
    private SquareArray squares;
    @FXML
    private Polygon triangle_gray;
    @FXML
    private Polygon triangle_white;
    @FXML
    private Polygon rectangle1;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Pane reset_button;
    @FXML
    private Timer timer;
    @FXML
    private Counter counter;
    @FXML
    private Pane upper_panel;
            
    
    private static Minesweeper a;
    
    public static final int N_MINES = 40;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML_Index.fxml"));
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().addAll(this.getClass().getResource("/minesweeper/Index.css").toExternalForm());
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setHeight(560);
        stage.setWidth(460);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void setA (Minesweeper x){
        a = x;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeStyle();
        squares.shuffle();
        setA(this);
        counter.set(N_MINES);
    }
    
    public void resetClick () {
        reset_button.setId("resetClicked");
    }
    
    public void resetRelease () {
        reset_button.setId("resetUnclicked");
        squares.reset();
        a.resetTimer();
        counter.set(N_MINES);
    }
    
    public static void setFlags(int i) {
        a.counter.set(i);
    }
    
    public static void gameWon (){
        a.reset_button.setId("resetGameWon");
    } 
    public static void gameOver () {
        a.reset_button.setId("resetGameOver");
        a.stopTimer();
    }
    
    public void stopTimer() {
        timer.stop();
    }
    
    public void resetTimer() {
        timer.reset();
    }
    
    private void initializeStyle() {
        reset_button.setLayoutX(201.00);
        reset_button.setLayoutY(30.00);
        upper_panel.setLayoutX(20.00);
        upper_panel.setLayoutY(20.00);
        triangle_gray.setFill(Color.GREY);
        triangle_gray.getPoints().addAll(new Double[]{
            440.0, 10.0,
            440.0, 520.0,
            10.0, 520.0 
        });
        triangle_white.getPoints().addAll(new Double[]{
           10.0,10.0,
           10.0,520.0,
           440.0,10.0
        });
        triangle_white.setFill(Color.WHITE);
        rectangle1.getPoints().addAll(new Double[]{
            13.00,13.00,
            13.00,517.00,
            437.00,517.00,
            437.00,13.00
        });
    }
}
