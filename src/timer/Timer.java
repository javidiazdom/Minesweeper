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
        t1 = new Thread(this);
        setId("timer");
        setLayoutX(335.00);
        setLayoutY(30.00);
        backLabel = new Label ("888");
        this.getChildren().add(backLabel);
        backLabel.setId("numbers-back");
        backLabel.setTranslateY(-3.00);
        secondsLabel = new Label("");
        count = 0;
        secondsLabel.setId("numbers-front");
        secondsLabel.setTranslateY(-3.00);
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
        while (!t1.isInterrupted()) {
            try {
                Thread.sleep(1000);
                Platform.runLater(updater);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    
    
    public void incrementCount () {
        count++;
        secondsLabel.setText(String.format("%03d",count));
    }
    
    public void stop() {
        t1.interrupt();
    }
    
    public void reset () {
        count=0;
        secondsLabel.setText(String.format("%03d",count));
        t1 = new Thread(this);
        t1.setDaemon(true);
        t1.start();

    }
}
