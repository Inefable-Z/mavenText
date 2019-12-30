package com.example.TestNG;

import org.testng.annotations.Test;

public class 预期异常 {
	
	@Test(expectedExceptions = 预期异常.class,enabled = false)
	public void yqexception() {
		int i = 1/0;
		System.out.println("异常"+i);
	}
	
	@Test(timeOut = 2000)
	public void longTime() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("111");
	}
}
