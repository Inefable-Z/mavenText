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
	@Test(groups="����1")
	  public void test1() {
		  System.out.println("test1 from ����1");
		  Assert.assertTrue(true);
	  }
	  
	  @Test(groups="����1")
	  public void test11() {
		  System.out.println("test11 from ����1");
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
		  System.out.println("beforeTest test��ǩ���Է�������֮ǰ����");
	  }
	  
	  @AfterTest
	  public void afterTest() 
	  {
		  System.out.println("afterTest test��ǩ���Է�������֮������");
	  }
	  
	  @BeforeClass
	  public void beforeClass() 
	  {
		  System.out.println("beforeClass ���õ�ǰ��ĵ�һ�����Է���֮ǰ���У�ע�ͷ���������һ��");
	  }
	  
	  @AfterClass
	  public void afterClass() 
	  {
		  System.out.println("afterClass ���õ�ǰ��ĵ�һ�����Է���֮�����У�ע�ͷ���������һ��");
	  }
	  
	  @BeforeSuite
	  public void beforeSuite() 
	  {
		  System.out.println("beforeSuite �ڸ��׼������в��Զ�������ע�͵ķ���֮ǰ��������һ��");
	  }
	  
	  @AfterSuite
	  public void afterSuite() 
	  {
		  System.out.println("afterSuite �ڸ��׼������в��Զ�������ע�͵ķ���֮�󣬽�����һ��");
	  }
	  
	  //ֻ��group1��Ч����test1��test11
	  @BeforeGroups(groups="����1")
	  public void beforeGroups() 
	  {
		  System.out.println("*****************************beforeGroups ����1ǰִ��*************************************");
	  }
	  
	  //ֻ��group1��Ч����test1��test11
	  @AfterGroups(groups="����1")
	  public void afterGroups() 
	  {
		  System.out.println("************************afterGroups ����1��ִ��*********************************************");
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
		  System.out.println("beforeMethod ����ִ��ǰִ��");
	  }
	  
	  @AfterMethod
	  public void afterMethod() 
	  {
		  System.out.println("afterMethod ����ִ�к�ִ��");
	  }
}
