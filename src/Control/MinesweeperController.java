package Control;

import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import Model.*;
import View.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author javidiazdom
 */
public class MinesweeperController implements Initializable {
   @FXML
   BoardDisplay boardDisplay;
    
   @FXML
   TimerDisplay timerDisplay;
   
   @FXML
   CounterDisplay counterDisplay;
   
   @FXML
   Pane resetButton;
   
   TimerController timerController;
   Counter counter;
   SquareArray squares;
   
   private boolean gameOnCourse;
   
   @FXML 
    public void handleClickGrid (MouseEvent event) {
        if (gameOnCourse) {
            int x = (int)Math.floor(event.getX() / 25.0);
            int y = (int)Math.floor(event.getY() / 25.0);

            switch (event.getButton()) {
                case PRIMARY:
                    handleLeftClick(x,y);
                    break;
                case SECONDARY: 
                    handleRightClick(x,y);
                    break;
                default: ;
            }
        }
    }
    
    public void handleResetClick() {
        resetButton.setId("resetClicked");
    }
    
    public void handleResetRelease() {
        resetButton.setId("resetUnclicked");
        GameLogic.resetGame(boardDisplay, squares, counterDisplay, counter, timerController);
        gameOnCourse = true;
    }
    
    private void handleLeftClick(int x,int y) {
        Node clicked = boardDisplay.getChildren().get(x*16+y);
        switch (squares.getState(x,y)) {
            case UNVEILED:
                break;
            case HIDDEN:
                if (squares.isMine(x, y)) {
                    clicked.setId("bomb");
                    squares.setState(SquareStates.UNVEILED, x, y);
                    timerController.stop();
                    resetButton.setId("resetGameOver");
                    gameOnCourse = false;
                } else {
                    GameLogic.unveilChain(boardDisplay,squares, x, y);
                    if (GameLogic.checkIfGameWon(squares)) {
                        resetButton.setId("resetGameWon");
                        gameOnCourse = false;
                    }
                }
                
                break;
            case FLAGGED:
                clicked.setId("unclickedCell");
                squares.setState(SquareStates.HIDDEN, x, y);
                counter.decrement();
                counterDisplay.setCount(counter.getCount());
        }
    }
    
    private void handleRightClick(int x, int y) {
        Node clicked = boardDisplay.getChildren().get(x*16+y);
        switch (squares.getState(x, y)) {
            case HIDDEN:
                clicked.setId("flagged");
                squares.setState(SquareStates.FLAGGED, x, y);
                counter.increment();
                counterDisplay.setCount(counter.getCount());
                break;
            case FLAGGED:
                clicked.setId("unclickedCell");
                squares.setState(SquareStates.HIDDEN, x, y);
                counter.decrement();
                counterDisplay.setCount(counter.getCount());
                break;
            default: break;
        }
    }

    /* 
    This method runs after the root element from this controller has been 
    fully procesed.
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        squares = new SquareArray(16);
        squares.setMines(30);
        timerController = new TimerController(timerDisplay, new Counter());
        timerController.start();
        counter = new Counter();
        gameOnCourse = true;
    }
}
