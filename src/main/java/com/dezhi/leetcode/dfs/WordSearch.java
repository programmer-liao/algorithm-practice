package com.dezhi.leetcode.dfs;

public class WordSearch {
    int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean exist = false;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, word, i, j, new boolean[board.length][board[i].length], 0);
            }
        }
        return exist;
    }

    void dfs(char[][] board, String word, int x, int y, boolean[][] visit, int index) {
        if (exist) {
            return;
        }
        if (board[x][y] != word.charAt(index)) {
            return;
        }
        visit[x][y] = true;
        if (index == word.length() - 1) {
            exist = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextx = x + direct[i][0];
            int nexty = y + direct[i][1];
            int lenx = board.length;
            int leny = board[0].length;
            if (nextx >= 0 && nextx < lenx && nexty >= 0 && nexty < leny && !visit[nextx][nexty]) {
                if (word.charAt(index + 1) == board[nextx][nexty]) {
                    dfs(board, word, nextx, nexty, visit, index + 1);
                    visit[nextx][nexty] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word));
    }
}
