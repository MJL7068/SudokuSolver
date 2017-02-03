package sudoku.sudokusolver;

public class Sudoku {

    private int[][] table;
    private int[][] alku;

    public Sudoku(int side) {
        int k = side;
        this.table = new int[k][k];
        this.alku = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                table[i][j] = 0;
            }
        }

        //2 x 2 testi
//        table[0][1] = 3;
//        table[2][1] = 2;
//        table[2][3] = 1;
//        table[3][1] = 1;
//        table[3][2] = 2;
//        table[3][3] = 3;
        //3 x 3 testi
//        table[0][0] = 5;
//        table[0][1] = 3;
//        table[0][4] = 7;
//
//        
//        table[1][0] = 6;
//        table[1][3] = 1;
//        table[1][4] = 9;
//        table[1][5] = 5;
//        
//        table[2][1] = 9;
//        table[2][2] = 8;
//        table[2][7] = 6;
//        
//        table[3][0] = 8;
//        table[3][4] = 6;
//        table[3][8] = 3;
//        
//        table[4][0] = 4;
//        table[4][3] = 8;
//        table[4][5] = 3;
//        table[4][8] = 1;
//        
//        table[5][0] = 7;
//        table[5][4] = 2;
//        table[5][8] = 6;
//        
//        table[6][1] = 6;
//        table[6][6] = 2;
//        table[6][7] = 8;
//        
//        table[7][3] = 4;
//        table[7][4] = 1;
//        table[7][5] = 9;
//        table[7][8] = 5;
//        
//        table[8][4] = 8;
//        table[8][7] = 7;
//        table[8][8] = 9;
        table[0][4] = 5;

        table[1][0] = 9;
        table[1][2] = 6;
        table[1][6] = 3;
        table[1][8] = 7;

        table[2][3] = 4;
        table[2][5] = 9;

        table[3][1] = 1;
        table[3][7] = 5;

        table[4][0] = 2;
        table[4][3] = 6;
        table[4][5] = 7;
        table[4][8] = 1;

        table[5][1] = 4;
        table[5][7] = 9;

        table[6][3] = 7;
        table[6][5] = 1;

        table[7][0] = 7;
        table[7][2] = 9;
        table[7][6] = 2;
        table[7][8] = 6;

        table[8][4] = 3;

        kopioi(table);

    }

    public void kopioi(int[][] table) {
        this.alku = new int[table.length][table[0].length];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                alku[i][j] = table[i][j];
            }
        }
    }

    public boolean isValid(int y, int x) {
        int side = table.length;
        int number = 0;
//        ArrayList<Integer> heigthLista = new ArrayList<>();
//        ArrayList<Integer> lengthLista = new ArrayList<>();

        int[] hlist = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] llist = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < side; i++) {
            number = table[y][i];
            if (number != 0) {
//                if (heigthLista.contains(number)) {
//                    return false;
//                }
//                heigthLista.add(number);
                if (hlist[number] != 0) {
                    return false;
                }
                hlist[number] = 1;
            }

            number = table[i][x];
            if (number != 0) {
//                if (lengthLista.contains(number)) {
//                    return false;
//                }
//                lengthLista.add(number);
                if (llist[number] != 0) {
                    return false;
                }
                llist[number] = 1;
            }
        }

        //heigthLista.clear();
        int[] klist = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int fromX = 0;
        int fromY = 0;
        int toX = 0;
        int toY = 0;
        if (table.length == 4) {
            toX = 2;
            if (x > 1) {
                fromX = 2;
            }
            if (y > 1) {
                fromY = 2;
            }

            toX = fromX + 2;
            toY = fromY + 2;
        } else if (table.length == 9) {
            toX = 3;
            if (x > 2 && x < 6) {
                fromX = 3;
            } else if (x > 5) {
                fromX = 6;
            }

            if (y > 2 && y < 6) {
                fromY = 3;
            } else if (y > 5) {
                fromY = 6;
            }

            toX = fromX + 3;
            toY = fromY + 3;
        }

        for (int i = fromX; i < toX; i++) {
            for (int j = fromY; j < toY; j++) {
                number = table[j][i];
                if (number != 0) {
//                    if (heigthLista.contains(number)) {
//                        return false;
//                    }
//                    heigthLista.add(number);
                    if (klist[number] != 0) {
                        return false;
                    }
                    klist[number] = 1;
                }
            }
        }

        return true;
    }

    public int[][] getTable() {
        return table;
    }

    public int[][] getAlku() {
        return alku;
    }
}
