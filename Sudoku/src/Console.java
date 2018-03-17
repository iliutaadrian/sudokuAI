package Sudoku.src;

import Sudoku.src.algorithm.Backtrack;
import Sudoku.src.algorithm.Bfs;
import Sudoku.src.algorithm.Dfs;
import Sudoku.src.entities.Sudoku;

import java.util.Scanner;

public class Console {
    private Sudoku initial;

    public Console(Sudoku initial) {
        this.initial = initial;
    }

    private void option() {
        Scanner scanner = new Scanner(System.in);

        try {
            String input = scanner.next();
            int in = Integer.parseInt(input);

            System.out.println("Initial state");
            initial.afisare();

            switch (in) {
                case 1:
                    backtracking();
                break;
                case 2:
                    dfs();
                break;
                case 3:
                    bfs();
                break;
                default:
                System.out.println("Enter a correct value");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }
    }

    private void showMenu() {
        System.out.println("What Sudoku.src.algorithm do you want to use?");
        System.out.println("1. Backtracking");
        System.out.println("2. Dfs");
        System.out.println("3. Bfs");
        System.out.print("Option: ");
    }


    public void display() {
        showMenu();
        option();
    }

    private void backtracking(){
        Backtrack backtrack = new Backtrack(initial);
        System.out.println("Final result ");
        backtrack.show();
    }

    private void bfs() {
        Bfs bfs = new Bfs(initial);
        System.out.println("Final result ");
        bfs.show();
    }

    private void dfs() {
        Dfs dfs = new Dfs(initial);
        System.out.println("Final result ");
        dfs.show();
    }
}