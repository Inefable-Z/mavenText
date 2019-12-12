package com.example.TestNG;

import org.testng.annotations.Test;

public class TestEnable {
	
	@Test(enabled = false)
	public void Test() {
		System.out.println("此句不执行");
	}
	
	@Test(enabled = true)
	public void Test2() {
		System.out.println("此句执行");
	}
}
