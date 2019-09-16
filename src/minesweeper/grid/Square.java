package minesweeper.grid;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javax.imageio.ImageIO;
/**
 *
 * @author javidiazdom
 */
public class Square extends Pane {
    protected boolean isMine;
    protected boolean isChecked;
    
    SquareArray parent;
    
    private int x;
    private int y;
    
    public Square(int i,int j, SquareArray parent){
        this.parent = parent; 
        setId("unclicked");
        setMinHeight(25.00);
        setMinWidth(25.00);
        this.x = i;
        this.y = j;
        setOnMousePressed(new EventHandler<MouseEvent> () {
            public void handle(MouseEvent e) {
                Object obj = e.getSource();
                if (obj instanceof Square) {
                    Square s = (Square) obj;
                    if (e.getButton() == MouseButton.PRIMARY) {
                        parent.handleClick(s);
                    } else {
                        handleSecondaryClick();
                    }
                }
            }
        });
    }
    public void setMine() {
        isMine = true;
        setId("unclicked");
    }
    
    public boolean check() {
        isChecked = true;
        if (isChecked) {
            if (isMine) {
                setId("mine");
            } else {
                setId("notmine");
            }
        }
        return isMine;
    }
    
    
    public void reset (boolean mine) {
        isMine = true;
        isChecked = false;
    }
    
    private void handleSecondaryClick () {
        setId("flag");
        parent.addFlag();
    }
    
}
