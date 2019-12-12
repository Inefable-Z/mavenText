package com.example.TestNG;

import org.testng.annotations.Test;

public class TestException {
	@Test(expectedExceptions = ArithmeticException.class)
	
    public void MyTestException() {
        int i = 1 * 0;
        System.out.println("After division the value of i is :"+ i);
    }

}
