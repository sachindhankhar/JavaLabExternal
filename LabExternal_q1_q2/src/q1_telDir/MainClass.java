package q1_telDir;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class MainClass {
	public static void main(String []args) {
		PhoneDir pd= new PhoneDir();
		pd.saveNewNumber(11,"sanchit");
		pd.saveNewNumber(12,"rishikesh");
		pd.saveNewNumber(13,"piyush");
		
		IncomingCalls ic=new IncomingCalls();
		ic.giveCall(12,"1900");
		ic.giveCall(15,"1300");
		ic.giveCall(13,"1650");
		ic.giveCall(17,"0930");
		
		Scanner sc =new Scanner(System.in);
		
		Set<Integer> s=ic.missed.keySet();
		ArrayList<Integer> al=new ArrayList<Integer>(s);
		for(Integer num:al) {
			System.out.println("\nMobile Number-->"+num);
			System.out.println("Enter 1 to delete the call, 2 to go to next missed call ,3 to display call details");
			int ch=sc.nextInt();
			switch(ch) {
			case 1: ic.deleteCall(num);
					break;
			case 3: ic.displayDetails(pd,num);
					break;
			case 2: // do nothing
					break;
			default: break;
			}
		}
		
		while(true) {
			System.out.println("Enter 1 to add new no. in mobile directory");
			System.out.println("2 to delete num, 3 to display details, 4 to exit");
			int ch=sc.nextInt();
			switch(ch) {
				case 1: System.out.println("Enter number and name");
						pd.saveNewNumber(sc.nextInt(),sc.next());
						break;
				case 2: System.out.println("Enter number");
						pd.deleteNumber(sc.nextInt());
						break;
				case 3: System.out.println("Enter number");
						String name=pd.dir.get(sc.nextInt());
						System.out.println("\nName-->"+name);
						break;
				case 4: break;		
			}
			if(ch==4) break;
		}
		
		
		sc.close();
	}
}
