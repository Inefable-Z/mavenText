package com.example.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestForProvider {
	
	@DataProvider(name = "provideUser")
	public Object[][] provideData() {
 
		return new Object[][] { 
			{ "username1", "pw1" }, 
			{ "username2", "pw2" }, 
			{ "username3", "pw3" } 
		};
	}
	@Test(dataProvider = "provideUser")
	public void openWebSite(String username, String password) throws InterruptedException {
		System.out.println(username+password);
	}

}
