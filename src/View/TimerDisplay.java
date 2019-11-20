package View;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class TimerDisplay extends Pane {
    private final Label backLabel;
    private final Label secondsLabel;
    
    public TimerDisplay () {
        backLabel = new Label ("888");
        backLabel.setId("numbers-back");
        secondsLabel = new Label("");
        secondsLabel.setId("numbers-front");
        this.getChildren().add(backLabel);
        this.getChildren().add(secondsLabel);
        backLabel.setTranslateY(-3.00);
        secondsLabel.setTranslateY(-3.00);
    }
    
    public void setTime (int t) {
        secondsLabel.setText(String.format("%03d",t));
    }
    
    
}
