/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.grid;

/**
 *
 * @author javidiazdom
 */
public class Square {
    protected boolean isMine;
    protected boolean isChecked;
    
    public boolean check() {
        isChecked = true;
        return isMine;
    }
    
    public void reset (boolean mine) {
        isMine = mine;
        isChecked = false;
    }
}
