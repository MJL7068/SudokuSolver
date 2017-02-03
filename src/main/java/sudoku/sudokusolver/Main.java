package sudoku.sudokusolver;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        SudokuGame s = new SudokuGame(9);
        s.solve();

//        GraphicalUserInterface gui = new GraphicalUserInterface(s);
//        gui.start();        
    }
}
