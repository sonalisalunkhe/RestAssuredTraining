package DDTPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTTest {
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=new Object[3][2];
		
		data[0][0]="Fusername";
		data[0][1]="Fpassword";
		
		data[1][0]="Susername";
		data[1][1]="Spassword";
		
		data[2][0]="Tusername";
		data[2][1]="Tpassword";
		
		return data;
		
		
	}
	@Test(dataProvider="getData")
	public void  test_DDT(String  uname,String password) {
		
		System.out.println(uname);
		System.out.println(password);

		
	}

}
