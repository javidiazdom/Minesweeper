package minesweeper.grid;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
/**
 *
 * @author javidiazdom
 */
public class Square extends Region {
    protected boolean isMine;
    protected boolean isChecked;
    
    SquareArray parent;
    
    private int x;
    private int y;
    
    public Square(int i,int j, SquareArray parent){
        this.parent = parent; 
        setStyle("-fx-background-color: #d1d1d1;-fx-border-color: white grey grey white;-fx-border-width: 2;");
        setMinHeight(25.00);
        setMinWidth(25.00);
        this.x = i;
        this.y = j;
        setOnMousePressed(new EventHandler<MouseEvent> () {
            public void handle(MouseEvent e) {
                Object obj = e.getSource();
                if (obj instanceof Square) {
                    Square s = (Square) obj;
                    parent.handleClick(s);
                }
            }
        });
    }
    
    public boolean check() {
        isChecked = true;
        return isMine;
    }
    
    public void setMine() {
        isMine = true;
    }
    
    public void reset (boolean mine) {
        isMine = true;
        isChecked = false;
    }
    
    private int[] getCoordinates () {
        return new int[]{x,y};
    }
}
