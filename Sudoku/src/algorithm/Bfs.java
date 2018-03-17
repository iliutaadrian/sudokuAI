package Sudoku.src.algorithm;

import Sudoku.src.entities.Sudoku;

import java.util.LinkedList;

public class Bfs {

    private Sudoku stare_ini;

    public Bfs(Sudoku ini) {
        stare_ini = ini;
    }

    private Sudoku solve() {

        LinkedList<Sudoku> queue = new LinkedList<>();
        LinkedList<Sudoku> vizitate = new LinkedList<>();

        queue.add(stare_ini);
        vizitate.add(stare_ini);

        while(! queue.isEmpty()) {
            Sudoku s = queue.poll();

            if(s.completata())
                return s;

            int[] aux = s.firstFree();

            for (int val = 1; val <= s.getDimension(); val++) {
                Sudoku s_noua = new Sudoku(s);

                if (s_noua.legal(aux[0], aux[1], val)) {
                    s_noua.completeaza(aux[0], aux[1], val);
                    if (!vizitate.contains(s_noua)) {
                        queue.add(s_noua);
                        vizitate.add(s_noua);
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
        System.out.println("Bfs a durat: "+totalTime/1000.0);
    }
}
