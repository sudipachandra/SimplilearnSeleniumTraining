package com.simplilearntraining.day5.testNgPack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTTest {
	@Test(dataProvider="getLoginData")
	public void Login(String username, String password){
		System.out.println("username = " + username + " password = " + password);
	}
	@DataProvider
	public Object[][] getLoginData(){
		String[][] data = new String[2][2];
		data[0][0] = "user1";
		data[0][1] = "pass1";
		data[1][0] = "user2";
		data[1][1] = "pass2";
		return data;
	}
}