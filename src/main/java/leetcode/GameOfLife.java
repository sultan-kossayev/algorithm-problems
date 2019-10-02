package leetcode;

// https://leetcode.com/problems/game-of-life/
public class GameOfLife {

    /**
     * We apply bit masking in order to do in-place cell update.
     * Once we identify the next generation of the cell we apply bit masking to it as
     * if cell was 0 and then becomes 0 (in next generation) its value will be 0b00
     * if cell was 0 and then becomes 1 its value will be 0b10
     * if cell was 1 and then becomes 0 its value will be 0b01
     * if cell was 1 and then becomes 1 its value will be 0b11
     * <p>
     * Once bit mask is applied on a cell, to get cell's previous state is possible by &1.
     * The next state can be calculated by right shifting its value by 1 bit.
     * <p>
     * Time: O(N * M), N and M dimensions of the board
     * Space: O(1)
     */
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = eval(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int eval(int[][] board, int r, int c) {
        int live = 0;

        for (int i = Math.max(0, r - 1); i <= Math.min(r + 1, board.length - 1); i++) {
            for (int j = Math.max(0, c - 1); j <= Math.min(c + 1, board[i].length - 1); j++) {
                if (i != r || j != c) {
                    live += board[i][j] & 1;
                }
            }
        }

        if (board[r][c] == 1) {
            return live == 2 || live == 3 ? 0b11 : 0b01;
        } else {
            return live == 3 ? 0b10 : 0b00;
        }
    }
}
