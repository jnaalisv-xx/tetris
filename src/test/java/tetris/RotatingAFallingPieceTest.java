/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import junit.framework.*;

public class RotatingAFallingPieceTest {

    public static Test suite() {
        return new TestSuite(RotatingAFallingPieceTest.class.getDeclaredClasses());
    }

    public static class When_a_falling_piece_is_rotated_clockwise extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_falling_piece_can_be_rotated_clockwise() {
        	board.rotateFallingPieceCW();
            assertEquals("" +          		
                    "....T...\n" +
                    "....TT..\n" +
                    "....T...\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());  
        }
    }
    
    public static class When_a_falling_piece_is_rotated_counter_clockwise extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }
		public void test_falling_piece_can_be_rotated_counter_clockwise() {
			board.rotateFallingPieceCCW();
		    assertEquals("" +          		
		            "....T...\n" +
		            "...TT...\n" +
		            "....T...\n" +                      
		            "........\n" +
		            "........\n" +
		            "........\n", board.toString());  
		}
    }
    public static class When_there_is_no_room_to_rotate extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }
		public void test_left_wall() {
			board.rotateFallingPieceCW();
			board.moveLeft();
			board.moveLeft();
			board.moveLeft();
			board.moveLeft();			
            assertEquals("" +          		
                    "T.......\n" +
                    "TT......\n" +
                    "T.......\n" +                      
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());  

            assertFalse(board.rotateFallingPieceCW());         
		}
		
		public void test_right_wall() {
			board.rotateFallingPieceCCW();
			board.moveRight();
			board.moveRight();
			board.moveRight();
			assertTrue(board.rotateFallingPieceCCW());
			assertTrue(board.rotateFallingPieceCW());
		}		
		
		public void test_other_piece() {
			board.tick();
			board.tick();
			board.tick();
			board.tick();
			board.tick();
			assertFalse(board.hasFalling());
            board.drop(Tetrominoe.T_SHAPE);	
			board.tick();
			board.tick();
			//assertFalse(board.rotateFallingPieceCCW());
			//assertFalse(board.rotateFallingPieceCW());
		}
		
		public void test_wall_kick() { 
			board.rotateFallingPieceCW();
			board.tick();
			board.moveLeft();
			board.moveLeft();
			board.moveLeft();
			board.moveLeft();			
			assertEquals("" +
				 "........\n" +
				 "T.......\n" +
				 "TT......\n" +
				 "T.......\n" +
				 "........\n" +
				 "........\n", board.toString());	
			assertTrue(board.rotateFallingPieceCCW());
			assertEquals("" +
					 "........\n" +
					 ".T......\n" +
					 "TTT.....\n" +
					 "........\n" +
					 "........\n" +
					 "........\n", board.toString());				
			
		}
		
    // TODO: when piece is up against a wall (or piece) and it is rotated (no room to rotate), move it away from the wall ("wallkick")
    // See: http://bsixcentdouze.free.fr/tc/tgm-en/tgm.html
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick1.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick2.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick3.png
    }
}
