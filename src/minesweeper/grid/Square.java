package minesweeper.grid;

import javafx.scene.layout.Region;
/**
 *
 * @author javidiazdom
 */
public class Square extends Region {
    protected boolean isMine;
    protected boolean isChecked;
    
    private int x;
    private int y;
    
    public Square(int i,int j){
        setStyle("-fx-background-color: #b8b8b8");
        setHeight(31.8);
        setWidth(25.5);
        this.x = i;
        this.y = j;
        
    }
    
    public boolean check() {
        isChecked = true;
        return isMine;
    }
    
    public void reset (boolean mine) {
        isMine = mine;
        isChecked = false;
    }
}
