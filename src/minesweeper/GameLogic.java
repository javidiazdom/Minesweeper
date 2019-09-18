package minesweeper;

import minesweeper.grid.SquareArray;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javid
 */
public class GameLogic {
    private static SquareArray squares;
    
    public static void initGame (SquareArray squaresAux) {
        squares = squaresAux;
        squares.shuffle();
    }
    
    public static void resetGame () {
        squares.shuffle();
    }
}
