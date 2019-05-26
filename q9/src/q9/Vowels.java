package q9;

import java.util.ArrayList;



public class Vowels implements Runnable{
	ArrayList<String> al= new ArrayList<>();
	int count=0;
	String word;
	Vowels(){
		al.add("a");
		al.add("e");
		al.add("i");
		al.add("o");
		al.add("u");
	}
	public void run() {
	
		synchronized(MainClass.sc) {
			System.out.println("Enter a word");
			this.word=MainClass.sc.next();
		}
		for(int i=0;i<word.length();++i) {
			if(al.contains(String.valueOf(word.charAt(i)))) {
				this.count++;
			}
		}
		System.out.println("Number of vowels in "+word+" is: "+this.count);
	}
}
