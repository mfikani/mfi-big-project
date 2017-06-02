package mfi.old_packages.tutorials.hacketrank.all_contests.world_codesprint_7;

import java.util.Scanner;

public class GridlandMetro {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		short trains = scanner.nextShort();
		Double total = (double) 0;
		int rowIndex, startIndex, endIndex;

		for (int i = 0; i < trains; i++) {
			rowIndex = scanner.nextInt();
			startIndex = scanner.nextInt();
			endIndex = scanner.nextInt();
			
//			System.out.println("(endIndex - startIndex) - overlapSpace) + 1 = "+"("+endIndex+" - "+startIndex+") - "+overlapSpace+") + 1 = "+(((endIndex - startIndex) - overlapSpace) + 1));
			total += ((endIndex - startIndex) ) + 1;
		}

		total = (rows * columns) - total;
		
		int t = total.intValue();
		System.out.println(t);
//		System.out.println(total < 0 ? 0 : Integer.valueOf(i)(total));
	}

}

