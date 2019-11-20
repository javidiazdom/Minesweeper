package View;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author javidiazdom
 */
public class CounterDisplay extends Pane {
    private final Label backLabel;
    private final Label countLabel;
    
    public CounterDisplay () {
        backLabel = new Label ("888");
        backLabel.setId("numbers-back");
        countLabel = new Label("000");
        countLabel.setId("numbers-front");
        this.getChildren().add(backLabel);
        this.getChildren().add(countLabel);
        backLabel.setTranslateY(-3.00);
        countLabel.setTranslateY(-3.00);
    }
    
    public void setCount (int n) {
        countLabel.setText(String.format("%03d",n));
    }
}
