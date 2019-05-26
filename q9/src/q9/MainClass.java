package q9;

import java.util.Scanner;

public class MainClass{
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		Thread t1= new Thread(new Digits());
		Thread t2= new Thread(new Vowels());
		t1.start();
		t2.start();
	}
}
