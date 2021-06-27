package com.simplilearntraining.day5.testNgPack;

import org.testng.annotations.Test;
public class testngExample2 {
	@Test(priority=0)
	public void Login(){
		System.out.println("testngExample2 - Login");
		
	}
	
	@Test(priority=1)
	public void AccountEnquiry(){
		System.out.println("testngExample2 - AccountEnquiry");
	}
	
	@Test(priority=2)
	public void Reporting(){
		System.out.println("testngExample2 - Reporting");
	}
	
	@Test(priority=3)
	public void Logout(){
		System.out.println("testngExample2 - Logout");
	}
}