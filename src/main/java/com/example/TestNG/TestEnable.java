package com.example.TestNG;

import org.testng.annotations.Test;

public class TestEnable {
	
	@Test(enabled = false)
	public void Test() {
		System.out.println("�˾䲻ִ��");
	}
	
	@Test(enabled = true)
	public void Test2() {
		System.out.println("�˾�ִ��");
	}
}
