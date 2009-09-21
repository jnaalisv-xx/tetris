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
    
    public static class When_a_piece_is_moved_to_down extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_can_be_moved_down() {
        	
            assertEquals("" +          		
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());        	
        	board.moveDown();
            assertEquals("" +
                    "........\n" +            		
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
            board.tick();
            assertEquals("" +
                    "........\n" +            		
                    "........\n" +            		
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +
                    "........\n", board.toString());
        } 
    }     
    public static class When_a_piece_is_moved_left_over_board extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_cant_be_moved_left_over_board() {
        	
            assertEquals("" +          		
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());        	
        	board.moveLeft();
        	board.moveLeft();
        	board.moveLeft();        	
            assertEquals("" +          		
                    ".T......\n" +
                    "TTT.....\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());  
        	board.moveLeft();        	
            assertEquals("" +          		
                    ".T......\n" +
                    "TTT.....\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());              
        } 
    }      
    public static class When_a_piece_is_moved_right_over_board extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_cant_be_moved_right_over_board() {
        	
            assertEquals("" +          		
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());        	
        	board.moveRight();
        	board.moveRight();
        	board.moveRight();        	
            assertEquals("" +          		
                    "......T.\n" +
                    ".....TTT\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());  
        	board.moveRight();        	
            assertEquals("" +          		
                    "......T.\n" +
                    ".....TTT\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());              
        } 
    }      
    
    public static class When_a_piece_is_moved_down_over_board extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_cant_be_moved_down_over_board() {
        	
            assertEquals("" +          		
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());        	
        	board.tick();
        	board.tick();
        	board.tick();    
        	board.tick();          	
            assertEquals("" +
                    "........\n" +           		
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
            		"....T...\n" +
                    "...TTT..\n", board.toString());  
            assertTrue(board.hasFalling());    		
        	board.tick();          	
            assertEquals("" +
                    "........\n" +           		
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
            		"....T...\n" +
                    "...TTT..\n", board.toString());  
            assertFalse(board.hasFalling());             
        } 
    }      
    
    public static class When_a_piece_is_moved_left_over_another_piece extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_cant_be_moved_left_over_another_piece() {
        	
        	board.moveLeft();
        	board.moveLeft();
        	board.moveLeft();
            assertEquals("" +          		
                    ".T......\n" +
                    "TTT.....\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());  
            board.tick();
            board.tick();
            board.tick();
            board.tick();
            board.tick();
            assertEquals("" +          		
                    "........\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    ".T......\n" +
                    "TTT.....\n", board.toString());  
            board.drop(Tetrominoe.T_SHAPE);
            assertEquals("" +          		
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +                      
                    "........\n" +
                    ".T......\n" +
                    "TTT.....\n",  board.toString());            
        	board.tick();
        	board.tick();
        	board.tick();    
        	board.tick(); 
            assertEquals("" +          		
                    "........\n" +
                    "........\n" +
                    "........\n" +                      
                    "........\n" +
                    ".T..T...\n" +
                    "TTTTTT..\n",  board.toString());  
            assertTrue(board.hasFalling());
            assertFalse(board.moveLeft());
        } 
    }      
    public static class When_a_piece_is_moved_right_over_another_piece extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_cant_be_moved_right_over_another_piece() {
        	
        	board.moveRight();
        	board.moveRight();
            assertEquals("" +          		
                    "......T.\n" +
                    ".....TTT\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());  
            board.tick();
            board.tick();
            board.tick();
            board.tick();
            board.tick();
            assertEquals("" +          		
                    "........\n" +
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
                    "......T.\n" +
                    ".....TTT\n", board.toString());  
            board.drop(Tetrominoe.T_SHAPE);
            assertEquals("" +          		
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +                      
                    "........\n" +
                    "......T.\n" +
                    ".....TTT\n",  board.toString());            
        	board.tick();
        	board.tick();
        	board.tick();  
            assertEquals("" +          		
                    "........\n" +
                    "........\n" +
                    "........\n" +                      
                    "....T...\n" +
                    "...TTTT.\n" +
                    ".....TTT\n",  board.toString());  
            assertTrue(board.hasFalling());
            assertFalse(board.moveRight());
        } 
    }      
    
    // TODO: it can not be moved down if another piece is in the way (will stop falling)
    public static class When_a_piece_is_moved_down_over_another_piece_it_stops_falling extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_cant_be_moved_down_over_board() {
        	     	
        	board.tick();
        	board.tick();
        	board.tick();    
        	board.tick();          	  		
        	board.tick();          	
            assertEquals("" +
                    "........\n" +           		
                    "........\n" +                      
                    "........\n" +
                    "........\n" +
            		"....T...\n" +
                    "...TTT..\n", board.toString());  
            assertFalse(board.hasFalling()); 
            
            board.drop(Tetrominoe.T_SHAPE); 
            assertEquals("" +
                    "....T...\n" +           		
                    "...TTT..\n" +                      
                    "........\n" +
                    "........\n" +
            		"....T...\n" +
                    "...TTT..\n", board.toString());  
        	board.tick();
        	board.tick();   
            assertEquals("" +                    
                    "........\n" +
                    "........\n" +
                    "....T...\n" +           		
                    "...TTT..\n" +                      
            		"....T...\n" +
                    "...TTT..\n", board.toString()); 
            assertTrue(board.hasFalling());  
        	board.tick();   
            assertEquals("" +                    
                    "........\n" +
                    "........\n" +
                    "....T...\n" +           		
                    "...TTT..\n" +                      
            		"....T...\n" +
                    "...TTT..\n", board.toString()); 
            assertFalse(board.hasFalling());          	
        } 
    }  

}
