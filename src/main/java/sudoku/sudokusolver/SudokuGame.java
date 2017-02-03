package sudoku.sudokusolver;

import java.util.Stack;

public class SudokuGame {

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Stack<Node> stack;
    private Sudoku sudoku;

    public SudokuGame(int side) {
        this.stack = new Stack<>();
        this.sudoku = new Sudoku(side);
    }

    public void solve() {
        print();
        int[][] table = sudoku.getTable();
        int[][] alku = sudoku.getAlku();
        Node node = null;
        boolean t = false;

        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table[y].length; x++) {
                if (t) {
                    x = node.x;
                    y = node.y;
                    if (table[y][x] < table.length) {
                        table[y][x]++;
                    } else {
                        table[y][x] = 0;
                        node = stack.pop();
                        continue;
                    }
                    t = false;
                }

                if (alku[y][x] == 0) {
                    while (table[y][x] == 0 || (!sudoku.isValid(y, x) && table[y][x] < table.length)) {
                        table[y][x]++;
                    }

                    if (sudoku.isValid(y, x)) {
                        stack.push(new Node(x, y));
                        continue;
                    }

                    if (table[y][x] == table.length) {
                        table[y][x] = 0;
                        node = stack.pop();
                        t = true;
                    }
                }
            }
        }

        print();
    }

    public void print() {
        int[][] table = sudoku.getTable();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
