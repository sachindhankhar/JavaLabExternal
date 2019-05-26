package q9;

import java.util.HashMap;


public class Digits implements Runnable{
	HashMap<String,String> hm= new HashMap<>();
	Integer num;
	Digits(){
		hm.put("1","one");
		hm.put("2","two");
		hm.put("3","three");
		hm.put("4","four");
		hm.put("5","five");
		hm.put("6","six");
		hm.put("7","seven");
		hm.put("8","eight");
		hm.put("9","nine");
		hm.put("0","zero");
	}
	public void run() {
		synchronized(MainClass.sc) {
			System.out.println("Enter a number which is more than 3 digits");
			this.num=MainClass.sc.nextInt();
		}
		String n=num.toString();
		for(int i=0;i<n.length();++i) {
			System.out.println(hm.get(String.valueOf(n.charAt(i))));
		}
	}
}
