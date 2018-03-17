package Sudoku.src.algorithm;

import Sudoku.src.entities.Sudoku;

public class Backtrack {
    private Sudoku sudoku;

    public Backtrack(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    private boolean solve(int i, int j) {
        if (i == sudoku.getDimension()+1) {
            i = 1;
            j++;

            if (j == sudoku.getDimension()+1)
                return true;
        }

        if (sudoku.getTabla()[i][j] != 0)
            return solve(i+1,j);

        for (int val = 1; val <= sudoku.getDimension(); val++) {
            sudoku.getTabla()[i][j] = val;
            if (sudoku.esteValida(i,j)) {
                if (solve(i+1,j))
                    return true;
            }
        }
        sudoku.getTabla()[i][j] = 0;
        return false;
    }

    public void show() {
        long startTime, endTime, totalTime; //for time keeping
        startTime = System.currentTimeMillis();

        if(solve(1,1)) {
            sudoku.afisare();
        }

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Backtrack a durat: "+totalTime/1000.0);
    }

}
