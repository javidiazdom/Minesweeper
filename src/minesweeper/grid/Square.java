package minesweeper.grid;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseButton;
import javafx.scene.control.Label;

/**
 *
 * @author javidiazdom
 */
public class Square extends Pane {
    protected boolean isMine;
    protected boolean isChecked;
    private boolean flagged;
    
    private Label nMinesAround;
    
    SquareArray parent;
    
    private int x;
    private int y;
    
    public Square(int i,int j, SquareArray parent){
        this.parent = parent;
        isChecked = false;
        flagged = false;
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
    
    public boolean isMine () {
        return isMine;
    }
    
    
    public void reset () {
        isMine = false;
        isChecked = false;
        setId("unclicked");
    }
    
    private void handleSecondaryClick () {
        if (!flagged && !isChecked) {
            setId("flag");
            parent.addFlag(1);
        } else if (!isChecked) {
            setId("unclicked");
            parent.addFlag(-1);
        }
        flagged = !flagged;
    }
    
    public int getX () {
        return x;
    }
    
    public int getY () {
        return y;
    }
    
    public boolean isChecked() {
        return isChecked;
    }
    
    public void setN (int in) {
        setId("notmine");
        isChecked=true;
        if (in != 0) {
            System.out.println(in);
            nMinesAround = new Label(""+in+"");
            nMinesAround.setId(""+in+"");
            this.getChildren().add(nMinesAround);
        }
    }
}
