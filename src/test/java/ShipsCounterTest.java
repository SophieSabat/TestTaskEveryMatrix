import com.sabat.ShipsCounter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShipsCounterTest {

    /**
     * This method tests the countOfShips() method in the ShipsCounter class when there are no ships on the board.
     * <p>
     * The method creates a 10x10 board without any ships and verifies that the countOfShips() method returns 0.
     *
     * @see ShipsCounter
     */
    @Test
    public void testNoShips() {
        int[][] board = new int[10][10];
        int expected = 0;
        int actual = ShipsCounter.countOfShips(board);
        assertEquals(expected, actual);
    }

    /**
     * Test method to verify the countOfShips method of the ShipsCounter class when there are ships on the board.
     * It creates a 10x10 two-dimensional array to represent the game board and populates it with ships, where 1 represents a cell containing a ship and 0 represents an empty cell.
     * It then calls the countOfShips method of the ShipsCounter class and compares the expected and actual results.
     *
     * @see ShipsCounter#countOfShips(int[][])
     */
    @Test
    public void testCountOfShips() {
        int[][] ships = {
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        int expected = 9;
        int actual = ShipsCounter.countOfShips(ships);
        assertEquals(expected, actual);
    }

    /**
     * Tests the behavior of the ShipsCounter.countOfShips() method when the board contains
     * more ships than the maximum allowed limit.
     * This test creates a 10x10 board containing 11 ships, which exceeds the maximum allowed limit
     * of 10. The expected result is 11, which indicates that the method correctly detects the
     * excessive number of ships on the board.
     *
     * @see ShipsCounter#countOfShips(int[][])
     */
    @Test
    public void testCountOfShipsExceedingLimit() {
        int[][] ships = {
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        int expected = 11;
        int actual = ShipsCounter.countOfShips(ships);
        assertEquals(expected, actual);
    }

    /**
     * Tests the counting of a one four-cell ship on a 10x10 board.
     * The test sets up a board with a single four-cell ship in the first row, and
     * then calls the ShipsCounter.countOfShips() method to count the number of
     * ships on the board. The expected result is 1, which is compared to the actual
     * result returned by the method using the assertEquals() method.
     *
     * @see ShipsCounter
     */
    @Test
    public void testOneFourCellShip() {
        int[][] board = new int[10][10];
        board[0][0] = 1;
        board[0][1] = 1;
        board[0][2] = 1;
        board[0][3] = 1;
        int expected = 1;
        int actual = ShipsCounter.countOfShips(board);
        assertEquals(expected, actual);
    }

    /**
     * Tests the "countOfShips" method of the "ShipsCounter" class with a 10x10 board
     * <p>
     * containing two three-cell ships placed horizontally.
     * <p>
     * The expected result is 2, which represents the number of ships on the board.
     */
    @Test
    public void testTwoThreeCellShipsHorizontally() {
        int[][] board = new int[10][10];
        board[0][0] = 1;
        board[0][1] = 1;
        board[0][2] = 1;
        board[3][0] = 1;
        board[3][1] = 1;
        board[3][2] = 1;
        int expected = 2;
        int actual = ShipsCounter.countOfShips(board);
        assertEquals(expected, actual);
    }

    /**
     * Tests the "countOfShips" method of the "ShipsCounter" class with a 10x10 board
     * <p>
     * containing two three-cell ships placed vertically.
     * <p>
     * The expected result is 2, which represents the number of ships on the board.
     */
    @Test
    public void testTwoThreeCellShipsVertically() {
        int[][] board = new int[10][10];
        board[0][0] = 1;
        board[1][0] = 1;
        board[0][1] = 1;
        board[1][1] = 1;
        board[2][1] = 1;
        int expected = 2;
        int actual = ShipsCounter.countOfShips(board);
        assertEquals(expected, actual);
    }

    /**
     * Tests the "countOfShips" method of the "ShipsCounter" class with a 10x10 board
     * <p>
     * containing four one-cell ships placed diagonally.
     * <p>
     * The expected result is 4, which represents the number of ships on the board.
     */
    @Test
    public void testFourOneCellShips() {
        int[][] board = new int[10][10];
        board[0][0] = 1;
        board[1][1] = 1;
        board[2][2] = 1;
        board[3][3] = 1;
        int expected = 4;
        int actual = ShipsCounter.countOfShips(board);
        assertEquals(expected, actual);
    }




    /**
     * This method tests the countOfShipsUsingStreams() method in the ShipsCounter class when there are no ships on the board.
     * <p>
     * The method creates a 10x10 board without any ships and verifies that the countOfShips() method returns 0.
     *
     * @see ShipsCounter#countOfShipsUsingStreams(int[][])
     */
    @Test
    public void testNoShipsUsingStreams() {
        int[][] board = new int[10][10];
        int expected = 0;
        int actual = ShipsCounter.countOfShipsUsingStreams(board);
        assertEquals(expected, actual);
    }

    /**
     * Test method to verify the countOfShipsUsingStreams() method of the ShipsCounter class when there are ships on the board.
     * It creates a 10x10 two-dimensional array to represent the game board and populates it with ships, where 1 represents a cell containing a ship and 0 represents an empty cell.
     * It then calls the countOfShips method of the ShipsCounter class and compares the expected and actual results.
     *
     * @see ShipsCounter#countOfShipsUsingStreams(int[][])
     */
    @Test
    public void testCountOfShipsUsingStreams() {
        int[][] ships = {
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        int expected = 9;
        int actual = ShipsCounter.countOfShipsUsingStreams(ships);
        assertEquals(expected, actual);
    }

    /**
     * Tests the behavior of the ShipsCounter.countOfShipsUsingStreams() method when the board contains
     * more ships than the maximum allowed limit.
     * This test creates a 10x10 board containing 11 ships, which exceeds the maximum allowed limit
     * of 10. The expected result is 11, which indicates that the method correctly detects the
     * excessive number of ships on the board.
     *
     * @see ShipsCounter#countOfShipsUsingStreams(int[][])
     */
    @Test
    public void testCountOfShipsExceedingLimitUsingStreams() {
        int[][] ships = {
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        int expected = 11;
        int actual = ShipsCounter.countOfShipsUsingStreams(ships);
        assertEquals(expected, actual);
    }

    /**
     * Tests the counting of a one four-cell ship on a 10x10 board.
     * The test sets up a board with a single four-cell ship in the first row, and
     * then calls the ShipsCounter.countOfShipsUsingStreams() method to count the number of
     * ships on the board. The expected result is 1, which is compared to the actual
     * result returned by the method using the assertEquals() method.
     *
     * @see ShipsCounter#countOfShipsUsingStreams(int[][])
     */
    @Test
    public void testOneFourCellShipUsingStreams() {
        int[][] board = new int[10][10];
        board[0][0] = 1;
        board[0][1] = 1;
        board[0][2] = 1;
        board[0][3] = 1;
        int expected = 1;
        int actual = ShipsCounter.countOfShipsUsingStreams(board);
        assertEquals(expected, actual);
    }

    /**
     * Tests the "countOfShipsUsingStreams" method of the "ShipsCounter" class with a 10x10 board
     * <p>
     * containing two three-cell ships placed horizontally.
     * <p>
     * The expected result is 2, which represents the number of ships on the board.
     */
    @Test
    public void testTwoThreeCellShipsHorizontallyUsingStreams() {
        int[][] board = new int[10][10];
        board[0][0] = 1;
        board[0][1] = 1;
        board[0][2] = 1;
        board[3][0] = 1;
        board[3][1] = 1;
        board[3][2] = 1;
        int expected = 2;
        int actual = ShipsCounter.countOfShipsUsingStreams(board);
        assertEquals(expected, actual);
    }

    /**
     * Tests the "countOfShipsUsingStreams" method of the "ShipsCounter" class with a 10x10 board
     * <p>
     * containing two three-cell ships placed vertically.
     * <p>
     * The expected result is 2, which represents the number of ships on the board.
     */
    @Test
    public void testTwoThreeCellShipsVerticallyUsingStreams() {
        int[][] board = new int[10][10];
        board[0][0] = 1;
        board[1][0] = 1;
        board[0][1] = 1;
        board[1][1] = 1;
        board[2][1] = 1;
        int expected = 2;
        int actual = ShipsCounter.countOfShipsUsingStreams(board);
        assertEquals(expected, actual);
    }

    /**
     * Tests the "countOfShipsUsingStreams" method of the "ShipsCounter" class with a 10x10 board
     * <p>
     * containing four one-cell ships placed diagonally.
     * <p>
     * The expected result is 4, which represents the number of ships on the board.
     */
    @Test
    public void testFourOneCellShipsUsingStreams() {
        int[][] board = new int[10][10];
        board[0][0] = 1;
        board[1][1] = 1;
        board[2][2] = 1;
        board[3][3] = 1;
        int expected = 4;
        int actual = ShipsCounter.countOfShipsUsingStreams(board);
        assertEquals(expected, actual);
    }
}
