import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

/* Name of the class has to be "Main" only if the class is public. */
class Bomberman
{
	public static void main (String[] args)
	{	
		Scanner in = new Scanner(System.in);
		String line  = in.nextLine();
		Scanner numbers = new Scanner(line);
		int row = numbers.nextInt();
		int col = numbers.nextInt();
		BigInteger seconds = new BigInteger(Integer.toString(numbers.nextInt()));
		BigInteger modBy = new BigInteger("2");


		int[][] map = new int[row][col];
		for(int i = 0; i < row; i++){
			String mapLine = in.nextLine();
			for(int j = 0; j < col; j++){
				if(mapLine.charAt(j) == '.'){
					map[i][j] = 0;
				}
				else{
					map[i][j] = 1;
				}
			}
		}
		if(seconds.equals(BigInteger.ONE)){
			printMap(map);
		}
		else{
		if(seconds.mod(modBy).equals(BigInteger.ZERO)){
			//mod by 2 it will be filled with all ones
			printAllBombs(row, col);
		}
		else{
			modBy =	new BigInteger("2");
				seconds = seconds.subtract(BigInteger.ONE);
				seconds = seconds.divide(modBy);
				int wow = seconds.intValue();
				for(int i = 1; i <= wow; i++){
					changeBoard(map, row, col);
				}
				printMap(map);
		}
		}
	}

//can change whats stored in the map so we dont have to do a 3rd check
	public static void changeBoard(int[][] map, int row, int col){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(map[i][j] == 0){
					map[i][j] = 2;
				}
			}
		}
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(map[i][j] == 1){
					changeSurrounding(map, i, j);
					map[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(map[i][j] == 2){
					map[i][j] = 1;
				}
			}
		}
	}

	public static void changeSurrounding(int[][] map, int row, int col){
		//up
		if((row -1) >= 0){
			if(map[row-1][col] == 2){
				map[row-1][col] = 0;
			}
		}
		//down
		if((row + 1) < map.length){
				if(map[row+1][col] == 2){
					map[row + 1][col] = 0;
				}
		}
		//left
		if((col - 1) >= 0){
			if(map[row][col-1] == 2){
					map[row][col -1] = 0;
				}
		}
		//right
		if((col + 1) < map[0].length){
			if(map[row][col + 1] == 2){
					map[row][col + 1] = 0;
				}
		}
	}

	public static void printMap(int[][] map){
				StringBuilder sb = new StringBuilder();
		for(int i = 0; i < map.length; i++){
			if(i != 0){
				System.out.println(sb.toString());
			}
			sb = new StringBuilder();
			for(int j = 0; j < map[0].length; j++){
				if(map[i][j] == 1){
				sb.append("O");
			}
			else{
				sb.append(".");
			}
			}
		}
		System.out.println(sb.toString());
	}

	public static void printAllBombs(int r, int c){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < r; i++){
			if(i != 0){
				System.out.println(sb.toString());
			}
			sb = new StringBuilder();
			for(int j = 0; j < c; j++){
				sb.append("O");
			}
		}
		System.out.println(sb.toString());
	}
}