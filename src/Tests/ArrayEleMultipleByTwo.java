package Tests;

public class ArrayEleMultipleByTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6,7,8,9,10,122};
		
		for(int n:arr) {
			if(n%2==0) {
				System.out.println(n);
			}
		}
	}

}
