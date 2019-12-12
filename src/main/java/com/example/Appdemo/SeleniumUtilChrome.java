package com.example.Appdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * seleunim 启动谷歌浏览器
 */
public class SeleniumUtilChrome {
	// 浏览器程序的路径
	private String webBrowserPath = "";

	private WebDriver driver = null;

	private String loginUrl = "https://platform.xd57.com:5007/login.phtml";// 登录页
	private String username = "wu37"; // 帐号
	private String password = "123456"; // 密码密码

	
	// 初始化 selenium要调用的浏览器并启动
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriver.exe";//谷歌
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-infobars");
		driver = new ChromeDriver(option);
	}

	// 关闭浏览器
	public void quitDrvier() {
		if (null != driver) {
			driver.quit();
		}
	}

	public void waitForSecond() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 模拟登录过程
	public void login() {
		driver.manage().window().maximize();
		driver.get(loginUrl); 
		waitForSecond();
		WebElement element = driver.findElement(By.id("username"));// 找到id名为 uin的dom 元素
		element.sendKeys(username);// 当前element为 uin输入框，将用户名填到这个输入框
		waitForSecond(); // 让进程等待一会，避免偶尔出现的元素获取异常
		element = driver.findElement(By.id("password"));// 找到id名为p的 dom元素
		element.sendKeys(password);// 将密码填入
		waitForSecond();
		//element = driver.findElement(By.id("info_error"));// 找到登录按钮
		element = driver.findElement(By.xpath("//input[@type='submit']"));// 找到登录按钮
		waitForSecond();
		element.click(); // 点击登录按钮
	}
	//登录成功后
	public void work() {////div[@class='paginatorBatchSizes']/span
		WebElement element = driver.findElement(By.linkText("混服"));
		element.click(); // 点击按钮
	}

	public void demo() {
		init();
		login();
		waitForSecond();
		work();
		//quitDrvier();
	}
	
	public static void main(String[] args) {
		SeleniumUtilChrome util = new SeleniumUtilChrome();
		util.demo();
	}

}
