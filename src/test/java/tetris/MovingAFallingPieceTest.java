/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import junit.framework.*;

public class MovingAFallingPieceTest {

    public static Test suite() {
        return new TestSuite(MovingAFallingPieceTest.class.getDeclaredClasses());
    }

    public static class When_a_piece_is_moved_to_the_left extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_can_be_moved_left() {
        	
        	board.moveLeft();
            assertEquals("" +
                    "...T....\n" +
                    "..TTT...\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
            board.tick();
            assertEquals("" +
                    "........\n" +            		
                    "...T....\n" +
                    "..TTT...\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        	board.moveLeft();
        	board.moveLeft();
            assertEquals("" +
                    "........\n" +            		
                    ".T......\n" +
                    "TTT.....\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        	board.moveLeft();
            assertEquals("" +
                    "........\n" +            		
                    ".T......\n" +
                    "TTT.....\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        } 
    }    
    
    
    // TODO: a falling piece can be moved right
    public static class When_a_piece_is_moved_to_the_right extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_can_be_moved_right() {
        	
        	board.moveRight();
            assertEquals("" +
                    ".....T..\n" +
                    "....TTT.\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
            board.tick();
            assertEquals("" +
                    "........\n" +            		
                    ".....T..\n" +
                    "....TTT.\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        	board.moveRight();
        	board.moveRight();
            assertEquals("" +
                    "........\n" +            		
                    "......T.\n" +
                    ".....TTT\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        } 
    }  
    
    // TODO: a falling piece can be moved down
    // TODO: it will not move left over over the board
    // TODO: it will not move right over over the board
    // TODO: it will not move down over over the board (will stop falling)
    // TODO: it can not be moved left if another piece is in the way
    // TODO: it can not be moved right if another piece is in the way
    // TODO: it can not be moved down if another piece is in the way (will stop falling)

    // P.S. Take into consideration, that part of the piece's area may be empty cells.
    // Only non-empty cells should take part in the collision checks.
}
