package q1_telDir;

import java.util.HashMap;

public class PhoneDir {
	HashMap<Integer,String> dir= new HashMap<Integer,String>();
	public void saveNewNumber(Integer num,String name) {
		if(dir.containsKey(num)) {
			System.out.println("Already present!");
		}else {
			dir.put(num,name);
			System.out.println("Number Saved!");
		}
		
	}
	public void deleteNumber(Integer num) {
		dir.remove(num);
	}
	public void displayDirectory() {
		System.out.println(dir);
	}
	public HashMap<Integer,String> giveDirectory(){
		return dir;
	}
}
