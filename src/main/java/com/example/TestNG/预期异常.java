package com.example.TestNG;

import org.testng.annotations.Test;

public class Ԥ���쳣 {
	
	@Test(expectedExceptions = Ԥ���쳣.class,enabled = false)
	public void yqexception() {
		int i = 1/0;
		System.out.println("�쳣"+i);
	}
	
	@Test(timeOut = 2000)
	public void longTime() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("111");
	}
}
