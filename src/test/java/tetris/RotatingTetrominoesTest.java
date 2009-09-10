/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import junit.framework.*;

/**
 * @author Esko Luontola
 */
public class RotatingTetrominoesTest {

    public static Test suite() {
        return new TestSuite(RotatingTetrominoesTest.class.getDeclaredClasses());
    }


    public static class All_shape_instances extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = Tetrominoe.T_SHAPE;
        }

        public void test_Are_immutable() {
            String original = shape.toString();
            shape.rotateRight();
            assertEquals(original, shape.toString());
            shape.rotateLeft();
            assertEquals(original, shape.toString());
        }
    }



    public static class The_T_shape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = Tetrominoe.T_SHAPE;
        }

        public void test_Is_shaped_like_T() {
            assertEquals("" +
                    ".T.\n" +
                    "TTT\n" +
                    "...\n", shape.toString());
        }

        public void test_Can_be_rotated_right_3_times() {
            shape = shape.rotateRight();
            assertEquals("" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateRight();
            assertEquals("" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateRight();
            assertEquals("" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n", shape.toString());
        }

        public void test_Can_be_rotated_left_3_times() {
            shape = shape.rotateLeft();
            assertEquals("" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateLeft();
            assertEquals("" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateLeft();
            assertEquals("" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n", shape.toString());
        }

        public void test_Rotating_it_4_times_will_go_back_to_the_original_shape() {
            String originalShape = shape.toString();
            shape = shape.rotateRight().rotateRight().rotateRight().rotateRight();
            assertEquals(originalShape, shape.toString());
            shape = shape.rotateLeft().rotateLeft().rotateLeft().rotateLeft();
            assertEquals(originalShape, shape.toString());
        }
    }

    public static class The_I_shape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = Tetrominoe.I_SHAPE;
        }

        public void test_Is_shaped_like_I() {
            assertEquals("" +
                    ".....\n" +
                    ".....\n" +
                    "IIII.\n" +
                    ".....\n" +
                    ".....\n", shape.toString());
        }

        public void test_Can_be_rotated_right_once() {
            shape = shape.rotateRight();
            assertEquals("" +
                    ".....\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n", shape.toString());
        }

        public void test_Can_be_rotated_left_once() {
            shape = shape.rotateLeft();
            assertEquals("" +
                    ".....\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n", shape.toString());
        }

        public void test_Rotating_it_twise_will_get_back_to_the_original_shape() {
            String originalShape = shape.toString();
            shape = shape.rotateRight().rotateRight();
            assertEquals(originalShape, shape.toString());
            shape = shape.rotateLeft().rotateLeft();
            assertEquals(originalShape, shape.toString());
        }
    }

    public static class The_O_shape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = Tetrominoe.O_SHAPE;
        }

        public void test_Is_shaped_like_O() {
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }

        public void test_Can_not_be_rotated_right() {
            shape = shape.rotateRight();
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }

        public void test_Can_not_be_rotated_left() {
            shape = shape.rotateLeft();
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }
    }

}
