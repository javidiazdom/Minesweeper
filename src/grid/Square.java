package grid;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseButton;
import javafx.scene.control.Label;

/**
 *
 * @author javidiazdom
 */
public class Square extends Pane {
    protected boolean isChecked;
    private boolean flagged;
    
    private Label nMinesAround;
    private int nMinesAr;
    
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
        nMinesAr = 0;
        setOnMousePressed((MouseEvent e) -> {
            Object obj = e.getSource();
            if (obj instanceof Square) {
                Square s = (Square) obj;
                if (e.getButton() == MouseButton.PRIMARY) {
                    parent.handleClick(s);
                } else {
                    handleSecondaryClick();
                }
            }
        });
    }
    public void setMine() {
        nMinesAr = -1;
        setId("unclicked");
    }
    
    public boolean check() {
        if (!isChecked) {
            if (nMinesAr == -1) {
                setId("mine");
            } else {
                setId("notmine");
            }
        }
        return nMinesAr == -1;
    }
    
    public boolean isMine () {
        return nMinesAr==-1;
    }
    
    
    public void reset () {
        nMinesAr = 0;
        isChecked = false;
        setId("unclicked");
        nMinesAr = 0;
        this.getChildren().remove(nMinesAround);
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
    
    public int setN () {
        setId("notmine");
        isChecked=true;
        if (nMinesAr != 0) {
            nMinesAround = new Label(""+nMinesAr+"");
            switch(nMinesAr) {
                case 1: nMinesAround.setStyle("-fx-text-fill:#0027ff");break;
                case 2: nMinesAround.setStyle("-fx-text-fill:#00d907");break;
                case 3: nMinesAround.setStyle("-fx-text-fill:#ff0000");break;
                case 4: nMinesAround.setStyle("-fx-text-fill:#001275");break;
                case 5: nMinesAround.setStyle("-fx-text-fill:#a30202");break;
            }
            this.getChildren().add(nMinesAround);
            nMinesAround.setTranslateX(7.00);
            nMinesAround.setTranslateY(3.00);
        }
        return nMinesAr;
    }
    
    public void addN () {
        if (nMinesAr != -1) {
            nMinesAr++;
        }
    }
}
