import java.util.*;

public class Game2048 {
    static final int SIZE = 4;
    static int[][] board = new int[SIZE][SIZE];
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        spawnTile();
        spawnTile();

        while (true) {
            printBoard();
            if (isGameOver()) {
                System.out.println("Game Over!");
                break;
            }

            System.out.print("Move (WASD): ");
            char move = scanner.next().toUpperCase().charAt(0);
            boolean moved = false;

            switch (move) {
                case 'W' -> moved = moveUp();
                case 'S' -> moved = moveDown();
                case 'A' -> moved = moveLeft();
                case 'D' -> moved = moveRight();
                default -> System.out.println("Invalid input!");
            }

            if (moved) {
                spawnTile();
            }
        }
    }

    static void spawnTile() {
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == 0) empty.add(new int[]{i, j});

        if (!empty.isEmpty()) {
            int[] pos = empty.get(rand.nextInt(empty.size()));
            board[pos[0]][pos[1]] = rand.nextInt(10) < 9 ? 2 : 4; 
        }
    }

    static void printBoard() {
        System.out.println("---------------");
        for (int[] row : board) {
            for (int val : row) {
                System.out.print((val == 0 ? "." : val) + "\t");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    static boolean moveLeft() {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            int[] row = board[i];
            int[] newRow = new int[SIZE];
            int index = 0;

            for (int j = 0; j < SIZE; j++) {
                if (row[j] != 0) {
                    if (newRow[index] == 0) {
                        newRow[index] = row[j];
                    } else if (newRow[index] == row[j]) {
                        newRow[index++] *= 2;
                        row[j] = 0;
                    } else {
                        newRow[++index] = row[j];
                    }
                }
            }

            if (!Arrays.equals(row, newRow)) {
                moved = true;
                board[i] = newRow;
            }
        }
        return moved;
    }

    static boolean moveRight() {
        rotate180();
        boolean moved = moveLeft();
        rotate180();
        return moved;
    }

    static boolean moveUp() {
        transpose();
        boolean moved = moveLeft();
        transpose();
        return moved;
    }

    static boolean moveDown() {
        transpose();
        rotate180();
        boolean moved = moveLeft();
        rotate180();
        transpose();
        return moved;
    }

    static void transpose() {
        for (int i = 0; i < SIZE; i++)
            for (int j = i + 1; j < SIZE; j++) {
                int tmp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = tmp;
            }
    }

    static void rotate180() {
        for (int i = 0; i < SIZE / 2; i++) {
            int[] tmp = board[i];
            board[i] = board[SIZE - 1 - i];
            board[SIZE - 1 - i] = tmp;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0, k = SIZE - 1; j < k; j++, k--) {
                int tmp = board[i][j];
                board[i][j] = board[i][k];
                board[i][k] = tmp;
            }
        }
    }

    static boolean isGameOver() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) return false;
                if (j < SIZE - 1 && board[i][j] == board[i][j + 1]) return false;
                if (i < SIZE - 1 && board[i][j] == board[i + 1][j]) return false;
            }
        return true;
    }
}

