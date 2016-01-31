package com.fedu.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	//to
	//subject
	//Amount
	
	@Test (dataProvider="getData")
	public void testSendingMail(String to, String subject, Integer msg)
	{
System.out.println(to+"......"+subject+"......"+msg+"..........");		
	}
	
	@DataProvider
	
	public Object[][] getData() {
		//row (2) -- Number of times test has to repeat
		//column (3) -- Number of parameters in the test data
		
		
		Object[][] data=new Object[2][3];
		
		//1st row
		data[0][0]= "abc@gmail.com";
		data[0][1] ="Hi";
		data[0][2] =1000;
		
		//2nd row
				data[1][0]= "xyz@yahoo.com";
				data[1][1] ="Hell";
				data[1][2] =34567;
						
				return data;
	}
}
