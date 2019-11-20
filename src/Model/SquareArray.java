/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author javidiazdom
 */
public class SquareArray {
    private SquareStates[][] squares;
    private boolean[][] mines;
    private int nMines;
    
    public SquareArray (int size) {
        squares = new SquareStates[size][size];
        mines = new boolean[size][size];
        for (SquareStates[] squaret : squares) {
            Arrays.fill(squaret, SquareStates.HIDDEN);
        }
        for (boolean[] minest : mines) {
            Arrays.fill(minest, false);
        }
    }
    
    public void setMines (int nMines) {
        nMines = nMines;
        Random r = new Random();
        int x,y;
        for (int i = 0 ; i < nMines; i++) {
            x = r.nextInt(squares.length-1);
            y = r.nextInt(squares.length-1);
            if (!mines[x][y]) {
                mines[x][y] = true;
            }
        }
    }

    public boolean isMine(int x, int y) {
        return mines[x][y];
    }
    
    public void setState(SquareStates in, int x, int y) {
        squares[x][y] = in;
    }

    public SquareStates getState(int x, int y) {
        return squares[x][y];
    }

    public int getMinesArround(int x, int y) {
        int res = 0;
        for (int i = x-1; i < x+2; i++) {
            for (int j = y-1; j < y+2; j++) {
                if (j < 0 || i < 0 || j >= squares.length || i >= squares.length)
                    continue;
                if (mines[i][j])
                    res++;
            }
        }
        return res;
    }
    
    public void reset () {
        for (boolean[] minest : mines) {
            Arrays.fill(minest, false);
        }
        for (SquareStates[] squaret : squares) {
            Arrays.fill(squaret, SquareStates.HIDDEN);
        }
    }

    public int getNUnveiled() {
        int res = 0; 
        for (SquareStates[] sqA : squares) {
            for (SquareStates sq : sqA) {
                if (sq == SquareStates.UNVEILED)
                    res++;
            }
        }
        return res;
    }

    public int getSize() {
        return squares.length * squares.length;
    }

    public int getNMines() {
        return nMines;
    }
}
