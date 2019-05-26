package q1_telDir;

import java.util.LinkedHashMap;


public class IncomingCalls {
	LinkedHashMap<Integer,String> missed=new LinkedHashMap<Integer,String>();
	public void giveCall(Integer num, String timeOfCall) {
		if(missed.size()==10) {
			Object key=missed.keySet().iterator().next();
			missed.remove(key);
		}
		missed.put(num,timeOfCall);
	}
	public void deleteCall(Integer num) {
		missed.remove(num);
	}
	public void displayDetails(PhoneDir pd,Integer num) {
		if(pd.giveDirectory().containsKey(num)) {
			System.out.println("Name-->"+pd.giveDirectory().get(num));
		}else {
			System.out.println("Name-->"+"Private Caller");
		}
		System.out.println("Mobile no-->"+num);
		System.out.println("Time of call-->"+missed.get(num));
	}
}
