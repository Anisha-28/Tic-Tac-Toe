import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
	static ArrayList<Integer> playerposs = new ArrayList<Integer>();
	static ArrayList<Integer> cpuposs = new ArrayList<Integer>();
	public static void main(String[] args) {
		
		char [] [] game= {
				{' ','|' , ' ', '|', ' '},
				{'-','+' , '-', '+', '-'},
				{' ','|' , ' ', '|', ' '},
				{'-','+' , '-', '+', '-'},
				{' ','|' , ' ', '|', ' '}
				};
	
		printGame(game);
		
		while(true) {
			Scanner sc = new Scanner (System.in);

			System.out.println("Enter you place (1-9):");
			int playerpos = sc.nextInt();
			while(playerposs.contains(playerpos) || cpuposs.contains(playerposs)) {
				
				playerpos = sc.nextInt();
			}
			placepos(game,playerpos,"player");
			String result = checkWinner();
			Random rand = new Random();
			int cpupos = rand.nextInt(9)+1;
			while(playerposs.contains(cpupos) || cpuposs.contains(playerposs)) {
				System.out.println("position taken");
				cpupos = rand.nextInt(9)+1;
			}
			placepos(game, cpupos,"cpu");
			
			printGame(game);
			
			result = checkWinner();
			if(result.length()>0) {
				
			System.out.println(result);
			break;
			}
		}
	}
	
		public static void printGame(char [] [] game) {

			for(char[] row: game) {
				for(char c : row) {
					System.out.print(c);
				}
				System.out.println();
			}
		}
		public static void placepos(char [] [] game, int pos, String user) {
			char symbol = ' ';
			
			if(user.equals("player")) {
				symbol ='x';
				playerposs.add(pos);
			} 
			else if(user.equals("cpu")) {
				symbol = '0';
				cpuposs.add(pos);
			}
			
			switch(pos) {
				case 1:
					game[0][0]=symbol;
					break;
				case 2:
					game[0][2]=symbol;
					break;
				case 3:
					game[0][4]=symbol;
					break;
				case 4:
					game[2][0]=symbol;
					break;
				case 5:
					game[2][2]=symbol;
					break;
				case 6:
					game[2][4]=symbol;
					break;
				case 7:
					game[4][0]=symbol;
					break;
				case 8:
					game[4][2]=symbol;
					break;	
				case 9:
					game[4][4]=symbol;
					break;
				default:
					break;
				
		}

		}
		
		public static String checkWinner() {
			
			List topRow = Arrays.asList(1, 2, 3);
			List midRow = Arrays.asList(4, 5, 6);
			List botRow = Arrays.asList(7, 8, 9);
			List leftCol = Arrays.asList(1, 4, 7);
			List midCol = Arrays.asList(2, 5, 8);
			List rightCol = Arrays.asList(3, 6, 9);
			List leftDiag = Arrays.asList(1, 5, 9);
			List rightDiag = Arrays.asList(3, 5, 7);
			
			
			List<List> win = new ArrayList<List>();
			win.add(topRow);
			win.add(midRow);
			win.add(botRow);
			win.add(leftCol);
			win.add(midCol);
			win.add(rightCol);
			win.add(leftDiag);
			win.add(rightDiag);
			
			for(List l : win) {
				if(playerposs.containsAll(l)) {
					return "Congratulations you won!";
				}
				else if (cpuposs.contains(l)) {
					return "You lose! Sorry :(";
				}
				else if(playerposs.size() + cpuposs.size() == 9) {
					return "Tie";
					
				}
			}
			return "";			
		}

}
