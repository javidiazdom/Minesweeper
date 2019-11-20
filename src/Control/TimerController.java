/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Counter;
import View.BoardDisplay;
import View.TimerDisplay;
import javafx.application.Platform;

/**
 *
 * @author javidiazdom
 */
public class TimerController {
    
    private final TimerDisplay timerDisplay;
    private final Counter timerModel;
    private Thread hilo;
    private boolean playing;
    
    private class TimerThread extends Thread {
        @Override
        public void run () {
            while (playing) {
                try {
                    Thread.sleep(1000);
                    Platform.runLater(() -> {
                        timerModel.increment();
                        timerDisplay.setTime(timerModel.getCount());
                    });
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public TimerController (TimerDisplay display, Counter model) {
        timerDisplay = display;
        timerModel = model;
        timerDisplay.setTime(0);
        playing = false;
        hilo = new TimerThread();
        hilo.setDaemon(true);
    }

    public void start () {
        playing = true;
        hilo.start();
    }
    
    public void stop () {
        playing = false;
        hilo.interrupt();
    }
    
    public void reset () {
        timerModel.reset();
        timerDisplay.setTime(timerModel.getCount());
        hilo = new TimerThread();
        hilo.setDaemon(true);
        start();
    }
    
    
}
