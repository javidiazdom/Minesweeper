/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author javidiazdom
 */
public class Counter {
    private int count;
    
    public Counter () {
        count = 0;
    }
    
    public int getCount () {
        return count;
    }
    
    public void increment () {
        count++;
    }
    
    public void decrement () {
        count--;
    }
    
    public void reset() {
        count = 0;
    }
}
