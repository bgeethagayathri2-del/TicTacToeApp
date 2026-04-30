import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    // Game board
    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    // Game state flags
    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    // Symbols
    static char humanSymbol = 'X';
    static char computerSymbol = 'O';

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("=== Tic Tac Toe Game ===");
        printBoard();

        // Continuous game loop
        while (!gameOver) {

            if (isHumanTurn) {
                humanMove();
            } else {
                computerMove();
            }

            printBoard();

            // Check win or draw
            if (checkWin(humanSymbol)) {
                System.out.println("Human Wins!");
                gameOver = true;
            } else if (checkWin(computerSymbol)) {
                System.out.println("Computer Wins!");
                gameOver = true;
            } else if (checkDraw()) {
                System.out.println("It's a Draw!");
                gameOver = true;
            }

            // Switch turn
            isHumanTurn = !isHumanTurn;
        }

        System.out.println("Game Over!");
    }

    // Human move
    static void humanMove() {
        int slot;
        int row, col;

        while (true) {
            System.out.print("Enter slot (1-9): ");
            slot = scanner.nextInt();

            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            if (slot >= 1 && slot <= 9 && board[row][col] == '-') {
                board[row][col] = humanSymbol;
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    // Computer random move (from UC7)
    static void computerMove() {
        int row, col;

        while (true) {
            int slot = random.nextInt(9) + 1;

            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            if (board[row][col] == '-') {
                board[row][col] = computerSymbol;
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Check win
    static boolean checkWin(char symbol) {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        // Diagonals
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }

        return false;
    }

    // Check draw
    static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Print board
    static void printBoard() {
        System.out.println("\nBoard:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}