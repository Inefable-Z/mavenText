package com.example.TestNG;

import org.testng.annotations.Test;

public class TestTimeOut {
  @Test(timeOut = 5000,enabled = false)
  public void f() throws InterruptedException{
	  System.err.println("�ȴ���������");
	  Thread.sleep(4000);
	  System.out.println("����");
  }
  
  @Test(timeOut = 5000)
  public void d() throws InterruptedException{
	  while(true) {
		  
	  }
  }
  
}
