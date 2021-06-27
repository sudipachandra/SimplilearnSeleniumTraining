package com.simplilearntraining.day5.testNgPack;

import org.testng.annotations.Test;
public class testngExample3 {
	@Test(priority=0)
	public void Login(){
		System.out.println("testngExample3 - Login");
	}
	
	@Test(priority=1)
	public void AccountEnquiry(){
		System.out.println("testngExample3 - AccountEnquiry");
	}
	
	@Test(priority=2)
	public void Reporting(){
		System.out.println("testngExample3 - Reporting");
	}
	
	@Test(priority=3)
	public void Logout(){
		System.out.println("testngExample3 - Logout");
	}
}