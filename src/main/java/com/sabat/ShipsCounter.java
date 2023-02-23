package com.sabat;

import org.apache.log4j.Logger;

import java.util.stream.IntStream;

public class ShipsCounter {
    static final Logger logger = Logger.getLogger(ShipsCounter.class);
    static int[][] ships = {
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


    /**
     * This method takes in a 2D array representing the battlefield and counts the number of ships present on it.
     * <p>
     * A ship is defined as a connected group of cells with a value of 1.
     * <p>
     * If a cell has a value of 1, the method calls the depthFirstSearch method to find all the cells in the same ship.
     *
     * @param ships a 2D array representing the battlefield
     * @return the number of ships present on the battlefield
     */
    public static int countOfShips(int[][] ships) {
        int count = 0;

        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {

                if (ships[i][j] == 1) {
                    count++;
                    depthFirstSearch(ships, i, j);
                }
            }
        }
        logger.info(count > 10
                ? "The allowed number of ships on the battlefield has been exceeded. The allowed number is 10.\n" : "");

        return count;
    }

    /**
     * Counts the number of ships on a battlefield represented as a 2D array using Java 8 streams.
     * <p>
     * A ship is represented by a cell with a value of 1.
     *
     * @param ships the 2D array representing the battlefield with 0s and 1s
     * @return the number of ships present in the battlefield
     */
    public static int countOfShipsUsingStreams(int[][] ships) {

        int count = (int) IntStream.range(0, ships.length)
                .flatMap(i -> IntStream.range(0, ships[i].length)
                        .filter(j -> ships[i][j] == 1)
                        .peek(j -> depthFirstSearch(ships, i, j)))
                .count();


        logger.info(count > 10
                ? "The allowed number of ships on the battlefield has been exceeded. The allowed number is 10.\n" : "");

        return count;
    }

    /**
     * This method performs depth-first search on a two-dimensional array of ships to find and mark all cells belonging to a ship that contains the initial cell (row, col). The algorithm searches only horizontally and vertically, and exits from the recursion if the array boundary is reached or the cell does not belong to the ship.
     *
     * @param ships a two-dimensional array of integers representing ships (1 for cells belonging to a ship, 0 for cells not belonging to a ship)
     * @param row   the row index of the initial cell to start searching from
     * @param col   the column index of the initial cell to start searching from
     */
    private static void depthFirstSearch(int[][] ships, int row, int col) {

        if (row < 0 || row >= ships.length || col < 0 || col >= ships[0].length || ships[row][col] == 0) {
            return;
        }
        ships[row][col] = 0;

        if (row < ships.length - 1 && ships[row + 1][col] == 1) {
            depthFirstSearch(ships, row + 1, col);
        } else if (col < ships.length - 1 && ships[row][col + 1] == 1) {
            depthFirstSearch(ships, row, col + 1);
        }
    }

    public static void main(String[] args) {
//        logger.info(countOfShips(ships));

        logger.info(countOfShipsUsingStreams(ships));
    }
}
