package cactpot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Cactpot {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int iPlayerChoice;
		int jPlayerChoice;
		int randomIndex = 0;
		Random rand = new Random();
		int counter = 0;
		int clicksLeft = 3;
		int arrowChoice;
		int sumOfChoice = 0;
		int prize;
		int totalPrize;
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> numbersInRandomOrder = new ArrayList<>();
        ArrayList<Cell> cells;
        
        for (int i = 0; i < 9; i++) {
        	 randomIndex = rand.nextInt(9 - numbersInRandomOrder.size());
        	 numbersInRandomOrder.add(numbers.get(randomIndex));
        	 numbers.remove(randomIndex);
        	
        }
        
        Cell cell1 = new Cell(numbersInRandomOrder.get(0), 0, 0);
        Cell cell2 = new Cell(numbersInRandomOrder.get(1), 0, 1);
        Cell cell3 = new Cell(numbersInRandomOrder.get(2), 0, 2);
        Cell cell4 = new Cell(numbersInRandomOrder.get(3), 1, 0);
        Cell cell5 = new Cell(numbersInRandomOrder.get(4), 1, 1);
        Cell cell6 = new Cell(numbersInRandomOrder.get(5), 1, 2);
        Cell cell7 = new Cell(numbersInRandomOrder.get(6), 2, 0);
        Cell cell8 = new Cell(numbersInRandomOrder.get(7), 2, 1);
        Cell cell9 = new Cell(numbersInRandomOrder.get(8), 2, 2);
        cells = new ArrayList<>(Arrays.asList(cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9));
        
        randomIndex = rand.nextInt(9);
        
        cells.get(randomIndex).setClicked(true);
        
        while (clicksLeft > 0) {
        	
        	showBoard(cells);
	        System.out.println("line: ");
	        iPlayerChoice = scanner.nextInt();
	        iPlayerChoice--;
	        System.out.println("row: ");
	        jPlayerChoice = scanner.nextInt();
	        jPlayerChoice--;
	        System.out.println();
	        
	        for (int i = 0; i < cells.size(); i++) {
	        	if (iPlayerChoice == cells.get(i).iPosition && jPlayerChoice == cells.get(i).jPosition) {
	        		if (cells.get(i).getClicked() == true) {
	        			System.out.println("already clicked");
	        			clicksLeft++;
	        		} else {
	        			cells.get(i).setClicked(true);
	        		}
	        		break;
	        	}
	        }
	        clicksLeft--;
        }
        
        showBoard(cells);
        
        System.out.println();
        
        System.out.println("Pick a line/row:");
        
        System.out.println("1) First Line");
        System.out.println("2) Second Line");
        System.out.println("3) Third Line");
        System.out.println("4) First Row");
        System.out.println("5) Second Row");
        System.out.println("6) Third Row");
        System.out.println("7) Diagonal");
        System.out.println("8) Second Diagonal");
        
        arrowChoice = scanner.nextInt();
        
        switch (arrowChoice) {
            case 1:
        	    sumOfChoice += cells.get(0).getValue() + cells.get(1).getValue() + cells.get(2).getValue();
        	    System.out.println(cells.get(0).getValue() + "+" + cells.get(1).getValue() + "+" +  cells.get(2).getValue());
        	    break;
            case 2:
            	sumOfChoice += cells.get(3).getValue() + cells.get(4).getValue() + cells.get(5).getValue();
            	System.out.println(cells.get(3).getValue() + "+" +  cells.get(4).getValue() + "+" +  cells.get(5).getValue());
            	break;
            case 3:
            	sumOfChoice += cells.get(6).getValue() + cells.get(7).getValue() + cells.get(8).getValue();
            	System.out.println(cells.get(6).getValue() + "+" +  cells.get(7).getValue() + "+" +  cells.get(8).getValue());
            	break;
            case 4:
            	sumOfChoice += cells.get(0).getValue() + cells.get(3).getValue() + cells.get(6).getValue();
            	System.out.println(cells.get(0).getValue() + "+" +  cells.get(3).getValue() + "+" +  cells.get(6).getValue());
            	break;
            case 5:
            	sumOfChoice += cells.get(1).getValue() + cells.get(4).getValue() + cells.get(7).getValue();
            	System.out.println(cells.get(1).getValue() + "+" +  cells.get(4).getValue() + "+" +  cells.get(7).getValue());
            	break;
            case 6:
            	sumOfChoice += cells.get(2).getValue() + cells.get(5).getValue() + cells.get(8).getValue();
            	System.out.println(cells.get(2).getValue() + "+" +  cells.get(5).getValue() + "+" +  cells.get(8).getValue());
            	break;
            case 7:
            	sumOfChoice += cells.get(0).getValue() + cells.get(4).getValue() + cells.get(8).getValue();
            	System.out.println(cells.get(0).getValue() + "+" +  cells.get(4).getValue() + "+" +  cells.get(8).getValue());
            	break;
            case 8:
            	sumOfChoice += cells.get(2).getValue() + cells.get(4).getValue() + cells.get(6).getValue();
            	System.out.println(cells.get(2).getValue() + "+" +  cells.get(4).getValue() + "+" +  cells.get(6).getValue());
            	break;
        }
        
        System.out.println();
        
        for (int i = 0; i < 9; i++) {
        	cells.get(i).setClicked(true);
        }
        
        showBoard(cells);
        
        System.out.println("Sum: " + sumOfChoice);
        
        prize = getPrize(sumOfChoice);
        System.out.println("You got " + prize + " MGP!!");
        
        
        
	}
	
	public static void showBoard(ArrayList<Cell> cells) {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
        		cells.get(counter).printNumber();
        		counter++;
        	}
        	System.out.printf("\n");
     
        }
	}
	
	public static int getPrize(int sum) {
		switch (sum) {
		    case 6:
		    	return 10000;
		    case 7:
		    	return 36;
		    case 8:
		    	return 720;
		    case 9:
		    	return 360;
		    case 10:
		    	return 80;
		    case 11:
		    	return 252;
		    case 12:
		    	return 108;
		    case 13:
		    	return 72;
		    case 14:
		    	return 54;
		    case 15:
		    	return 180;
		    case 16:
		    	return 72;
		    case 17:
		    	return 180;
		    case 18:
		    	return 119;
		    case 19:
		    	return 36;
		    case 20:
		    	return 306;
		    case 21:
		    	return 1080;
		    case 22:
		    	return 144;
		    case 23:
		    	return 1800;
		    case 24:
		    	return 3600;
		    
		    
			
		}
		return 0;
	}

	

}
