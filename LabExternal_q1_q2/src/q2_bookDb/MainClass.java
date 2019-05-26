package q2_bookDb;

import java.util.ArrayList;
import java.util.Collections;


public class MainClass {
	public static void main(String []args) {
		ArrayList<Book> al=new ArrayList<Book>();
		al.add(new Book("java","sanchit","tmh",300.0));
		al.add(new Book("dbms","rishikesh","mitPress",200.5));
		al.add(new Book("daa","sabya","pearson",450.0));
		al.add(new Book("ml","piyush","oxford",399.0));
		
		Collections.sort(al);
		for(Book li:al) {
			System.out.println(li.toString());
		}
		
	}
}
