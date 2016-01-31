package com.fedu.asserations;

import org.testng.Assert;
import org.testng.annotations.Test;



public class UsingAsserations {
	
	@Test
public void testYahoo()
{
	//Open Yahoo.com
	String expectedResult="Yahoo";
	String actualResult="NotYahoo";
	System.out.println("Befor Assertion");
	try {
	Assert.assertEquals(expectedResult, actualResult);
	}
	catch (Throwable t)
	{
		//This test is always pass
		//So we need Java code listener to fail the test
		System.out.println("Error occured");
	}
	System.out.println("After Assertion");
}
}
