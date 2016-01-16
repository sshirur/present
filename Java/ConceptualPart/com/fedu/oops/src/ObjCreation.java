package com.fedu.oops.src;

public class ObjCreation {
	public static void main(String[] args) {
	
		Obj ob=new Obj();
		ob.fun1();
	}

}

 class Obj {
	
	public void fun1()
	{
		System.out.println("In func1");
	}
	
}