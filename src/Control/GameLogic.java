package Control;

import Model.Counter;
import Model.SquareArray;
import Model.SquareStates;
import View.BoardDisplay;
import View.CounterDisplay;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author javidiazdom
 */
public class GameLogic {
    
    public static void unveilChain (BoardDisplay board,SquareArray squares, int x, int y) {
        if (squares.getState(x, y) == SquareStates.HIDDEN) {
            board.getChildren().get(x*16+y).setId("notmine");
            squares.setState(SquareStates.UNVEILED, x, y);
            int nMinesAround = squares.getMinesArround(x,y);
            if (nMinesAround == 0) {
                for (int i = x-1; i <= x+1; i++) {
                    for (int j = y-1; j <= y+1; j++) {
                        if ((j==y&&i==x) || j < 0 || i < 0 || j > 15 || i > 15)
                            continue;
                        unveilChain(board,squares, i, j);
                    }
                }
            } else {
                Pane actual = (Pane)board.getChildren().get(x*16+y);
                Label label = new Label("" + nMinesAround);
                switch (nMinesAround) {
                    case 1: label.setStyle("-fx-text-fill:#0027ff");break;
                    case 2: label.setStyle("-fx-text-fill:#00d907");break;
                    case 3: label.setStyle("-fx-text-fill:#ff0000");break;
                    case 4: label.setStyle("-fx-text-fill:#001275");break;
                    case 5: label.setStyle("-fx-text-fill:#a30202");break;
                }
                actual.getChildren().add(label);
            }
            
        }
    }
    
    public static boolean checkIfGameWon(SquareArray squares) {
        return squares.getNUnveiled() == squares.getSize() - squares.getNMines() + 1;
    }
    
    public static void resetGame (BoardDisplay boardDisplay,SquareArray squares,
            CounterDisplay counterDisplay, Counter counter,TimerController timerController) {
        squares.reset();
        squares.setMines(30);
        boardDisplay.reset();
        counter.reset();
        counterDisplay.setCount(counter.getCount());
        timerController.reset();
    }

    
}
