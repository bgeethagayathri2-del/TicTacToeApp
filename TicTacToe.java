/**
 * TicTacToe
 * UC5 validates whether a move is inside the board boundaries
 * and whether the selected cell is empty.
 */
public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    /**
     * Entry point of the program. Tests the validation logic
     * using sample row and column values.
     */
    public static void main(String[] args) {
        System.out.println(isValidMove(1, 1)); // example test
    }

    /**
     * Checks if the given row and column are within bounds
     * and if the target cell is empty.
     *
     * Input: row, column
     * Output: true if valid, false otherwise
     */
    static boolean isValidMove(int row, int col) {

        // Check boundaries
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }
}