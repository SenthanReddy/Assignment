package exercise;

import java.util.Scanner;

import exercise01.Exercise01;
import exercise02.Exercise02;
import exercise03.Exercise03;

public class Assignment {
	public static void main(String[] a) {
		System.out.println("Enter the exercise number");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		Exercise exercise = null;
		switch (choice) {
		case 1:
			exercise = new Exercise01();
			break;
		case 2:
			exercise= new Exercise02();
			break;
		case 3: 
			exercise= new Exercise03();
		 	break;
		default:
			System.out.println("currently only 3 exercises");

		}
		final Exercise finalTask = exercise;
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					if (finalTask != null) {
						finalTask.getInput();
						finalTask.execute();
						finalTask.writeOutput();
					}
				} catch (Exception e) {

				}
			}
		});
		t.start();
	}

}
