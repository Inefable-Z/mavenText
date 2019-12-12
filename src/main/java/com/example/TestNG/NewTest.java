package com.example.TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest {
	@Test(groups="区块1")
	  public void test1() {
		  System.out.println("test1 from 区块1");
		  Assert.assertTrue(true);
	  }
	  
	  @Test(groups="区块1")
	  public void test11() {
		  System.out.println("test11 from 区块1");
		  Assert.assertTrue(true);
	  }
	  
	  @Test(groups="groups2")
	  public void test2() 
	  {
		  System.out.println("test2 from group2");
		  Assert.assertTrue(true);
	  }
	  
	  @BeforeTest
	  public void beforeTest() 
	  {
		  System.out.println("beforeTest test标签测试方法运行之前运行");
	  }
	  
	  @AfterTest
	  public void afterTest() 
	  {
		  System.out.println("afterTest test标签测试方法运行之后运行");
	  }
	  
	  @BeforeClass
	  public void beforeClass() 
	  {
		  System.out.println("beforeClass 调用当前类的第一个测试方法之前运行，注释方法仅运行一次");
	  }
	  
	  @AfterClass
	  public void afterClass() 
	  {
		  System.out.println("afterClass 调用当前类的第一个测试方法之后运行，注释方法仅运行一次");
	  }
	  
	  @BeforeSuite
	  public void beforeSuite() 
	  {
		  System.out.println("beforeSuite 在该套件的所有测试都运行在注释的方法之前，仅运行一次");
	  }
	  
	  @AfterSuite
	  public void afterSuite() 
	  {
		  System.out.println("afterSuite 在该套件的所有测试都运行在注释的方法之后，仅运行一次");
	  }
	  
	  //只对group1有效，即test1和test11
	  @BeforeGroups(groups="区块1")
	  public void beforeGroups() 
	  {
		  System.out.println("*****************************beforeGroups 区块1前执行*************************************");
	  }
	  
	  //只对group1有效，即test1和test11
	  @AfterGroups(groups="区块1")
	  public void afterGroups() 
	  {
		  System.out.println("************************afterGroups 区块1后执行*********************************************");
	  }
	  
	  @BeforeGroups(groups="groups2")
	  public void beforeGroups2() 
	  {
		  System.out.println("-----------------------------------------");
	  }
	  @AfterGroups(groups="groups2")
	  public void afterGroups2() 
	  {
		  System.out.println("*******************************************");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() 
	  {
		  System.out.println("beforeMethod 方法执行前执行");
	  }
	  
	  @AfterMethod
	  public void afterMethod() 
	  {
		  System.out.println("afterMethod 方法执行后执行");
	  }
}
