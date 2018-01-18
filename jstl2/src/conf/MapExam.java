package conf;

import java.util.HashMap;
import java.util.Iterator;

public class MapExam {
	
	public static void main(String[] args) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		for(int i=0; i<10; i++) {
			hm.put(i+" ²ó", i);
		}
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			System.out.println(key+"  =  "+ hm.get(key));
		}
		System.out.println(it.hasNext());
	}
	
}
