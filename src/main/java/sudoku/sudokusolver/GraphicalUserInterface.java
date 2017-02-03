package sudoku.sudokusolver;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicalUserInterface {
    private SudokuGame sudoku;
    

    public GraphicalUserInterface(SudokuGame sudoku) {
        this.sudoku = sudoku;
    }
    
    public void start() {
        JFrame f = new JFrame();
        f.setSize(600, 600);
        f.add(createPanel());
        f.setVisible(true);
    }
    
    public JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                panel.add(new JLabel("0"));
            }
        }
        return panel;
    }
}
