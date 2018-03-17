package Sudoku.src.algorithm;

import java.util.LinkedList;
import java.util.Stack;

import Sudoku.src.entities.Sudoku;


public class Dfs {

	private Sudoku stare_ini;
	
	public Dfs(Sudoku ini) {
		stare_ini = ini;
	}
	
	private Sudoku solve() {

		Stack<Sudoku> stiva = new Stack<>();
		LinkedList<Sudoku> vizitate = new LinkedList<>();
		
		stiva.push(stare_ini);
		vizitate.add(stare_ini);
				
		while(! stiva.isEmpty()) {
			
			Sudoku s = stiva.pop();
			
			if(s.completata())
				return s;
			
			boolean gasit = false;
			
			for(int i=1; (i<=s.getDimension()) && (!gasit); i++) {
                for (int j = 1; (j <= s.getDimension()) && (!gasit); j++) {
                    if (s.getTabla()[i][j] == 0) {
                        gasit = true;
                        for (int val = 1; val <= s.getDimension(); val++) {
                            Sudoku s_noua = new Sudoku(s);
                            s_noua.completeaza(i, j, val);

                            if ((s_noua.esteValida(i, j)) && (!vizitate.contains(s_noua))) {
                                stiva.push(s_noua);
                                vizitate.add(s_noua);
                            }
                        }
                    }
                }
            }
		}
		return null;
	}

	public void show() {
		long startTime, endTime, totalTime;
		startTime = System.currentTimeMillis();

		Sudoku aux = solve();
		if(aux!=null)
			aux.afisare();
        else
            System.out.println("Nu s-a gasit o solutie.");

		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Dfs a durat: "+totalTime/1000.0);
	}
}
