package timer;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author javid
 */
public class Timer extends Pane implements Runnable {
    
    private Thread t1;
    private final Label backLabel;
    private Label secondsLabel;
    private int count;
    
    public Timer () {
        Thread t1 = new Thread(this);
        setId("timer");
        setLayoutX(335.00);
        setLayoutY(30.00);
        backLabel = new Label ("888");
        this.getChildren().add(backLabel);
        backLabel.setId("numbers-back");
        backLabel.setTranslateX(1.00);
        backLabel.setTranslateY(1.00);
        secondsLabel = new Label("");
        secondsLabel.setId("numbers-front");
        secondsLabel.setTranslateX(1.00);
        secondsLabel.setTranslateY(1.00);
        this.getChildren().add(secondsLabel);
        t1.setDaemon(true);
        t1.start();
    }
    
    
    
    @Override
    public void run () {
        Runnable updater = new Runnable () {
            @Override
            public void run () {
                incrementCount();
            }
        };
            while (true) {
            try {
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Algo salio mal");
            }
            Platform.runLater(updater);
        }
    }
    
    
    public void incrementCount () {
        count++;
        secondsLabel.setText(""+count);
    }
}
