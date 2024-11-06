package Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListClass {

	public static void main(String[] args) {

		ArrayList<String> a=new ArrayList();
		a.add("name");
		a.add("name1");
		a.add("name2");
		
		for(String val:a) {
			System.out.println(val);
		}
		
		System.out.println(a.contains("name"));
		System.out.println(a.contains("selenium"));

		String str[]= {"A","B","c"};
		
	List<String> newlist=Arrays.asList(str);
	
	System.out.println(newlist.contains("A"));
	}

}
