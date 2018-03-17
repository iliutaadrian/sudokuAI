package Sudoku.src;

import Sudoku.src.entities.Sudoku;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
        Sudoku initial = new Sudoku("C:\\Users\\Iliuta Adrian\\Desktop\\sudokuAI\\Sudoku\\src\\files\\input1.txt");

        Console console = new Console(initial);
        console.display();
    }

}
