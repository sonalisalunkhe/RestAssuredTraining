package Tests;

import java.util.ArrayList;
import java.util.Arrays;

public class CoreJava {

	public static void main(String[] args) {


		int num=5;
		String text="welcome to java";
		char c='A';
		double bool=5.99;
		boolean myCard=true;
		
		System.out.println(text);
		
		//Arrays
		int arr[]=new int[5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		
		int[] arr1= {1,2,3,4,5,6};
		
		System.out.println(arr[0]);
		System.out.println(arr1[1]);

		//printng all ele of array
		System.out.println("Element of Array arr[]:");

		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");

		}
		System.out.println();

		
		//String array
		String name[]= {"Sonali","Anika","Vaishali"};
		
		System.out.println("Element of Array name[]:");

		for(String s:name) {
			System.out.print(s+" ");

		}
		
		ArrayList<Integer> a = new ArrayList<>();

		
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4); // Corrected line
		a.removeAll(new ArrayList<>(Arrays.asList(1, 3, 4, 5)));
		System.out.println(a);
	}

}
