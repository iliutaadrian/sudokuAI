package Sudoku.src.entities;

import java.io.*;

public class Sudoku {
	private int dimension;
	private int completate;
	private int[][] tabla;
	
	public Sudoku(String fis) throws IOException {
		read(fis);
	}
	
	public Sudoku(Sudoku s) {
		this.dimension = s.dimension;
		tabla = new int[dimension+1][dimension+1];
		completate = 0;
		for(int i = 1; i<= dimension; i++)
			for(int j = 1; j<= dimension; j++)
				tabla[i][j] = s.tabla[i][j];
		completate = s.completate;
	}
	
	public boolean esteValida(int l, int c) {
		for(int i = 1; i<= dimension; i++)
			if((i !=l) && ( tabla[i][c] == tabla[l][c] ))
				return false;
		
		for(int j = 1; j<= dimension; j++)
			if((j !=c) && ( tabla[l][j] == tabla[l][c]))
                return false;

		int rad = (int)Math.sqrt(dimension);
		int l_start = l / rad;
		int c_start = c / rad;
		
		if(l % rad == 0) l_start -= 1;
		if(c % rad == 0) c_start -= 1;
		
		l_start = l_start * rad + 1;
		c_start = c_start * rad + 1;
		
		int l_end = l_start + rad - 1;
		int c_end = c_start + rad - 1;
		
		for(int i=l_start; i<=l_end; i++)
			for(int j=c_start; j<=c_end; j++)
				if((i!=l) && (j!=c) && (tabla[i][j]== tabla[l][c]))
					return false;
		
		return true;
	}

    public boolean legal(int linie, int coloana, int valoare){
        for(int i=1; i<=dimension; i++) {
            if (tabla[linie][i] == valoare)
                return false;
            if(tabla[i][coloana] == valoare)
                return false;
        }

        int rad = (int)Math.sqrt(dimension);
        int l_start = linie / rad;
        int c_start = coloana / rad;

        if(linie % rad == 0) l_start -= 1;
        if(coloana % rad == 0) c_start -= 1;

        l_start = l_start * rad + 1;
        c_start = c_start * rad + 1;

        int l_end = l_start + rad - 1;
        int c_end = c_start + rad - 1;

        for(int i=l_start; i<=l_end; i++)
            for(int j=c_start; j<=c_end; j++)
                if(tabla[i][j]== valoare)
                    return false;
        return true;
    }

	public void completeaza(int l, int c, int val) {
	    completate++;
        tabla[l][c] = val;
	}

	public int[] firstFree(){
        for(int i=1; i<=dimension ; i++) {
            for (int j = 1; j <= dimension; j++) {
                if (tabla[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public boolean completata() {
        return completate == dimension * dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public int[][] getTabla() {
        return tabla;
    }

    private void read(String fis) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fis));
        dimension = Integer.parseInt(br.readLine());
        tabla = new int[dimension +1][dimension +1];
        completate = 0;

        for(int i = 1; i<= dimension; i++)
        {
            String[] s = br.readLine().split(" ");
            for(int j=0; j<s.length; j++)
            {
                tabla[i][j+1] = Integer.parseInt(s[j]);
                if(tabla[i][j+1] != 0)
                    completate++;
            }
        }
        br.close();

    }

    public void afisare(){
        for(int i = 1; i<=dimension; i++){
            if((i-1)%Math.sqrt(dimension)==0){
                System.out.println("-------------------------");
            }
            for(int j = 1; j<=dimension; j++){
                if((j-1)%Math.sqrt(dimension)==0)
                    System.out.print("| "+tabla[i][j]+" ");
                else
                    System.out.print(tabla[i][j]+" ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}