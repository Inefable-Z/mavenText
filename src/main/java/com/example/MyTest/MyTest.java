package com.example.MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * seleunim 启动谷歌浏览器
 */
public class MyTest {
	// 浏览器程序的路径
	private String webBrowserPath = "";

	private WebDriver driver = null;

	private String loginUrl = "http://webgame.94php.com/index.html";// 登录页
	private String username = "123456"; // 帐号
	private String password = "123456"; // 密码

	// 初始化 selenium要调用的浏览器并启动
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriver.exe";// 谷歌
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		driver = new ChromeDriver();
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
	public void waitForSecond2() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 模拟登录过程
	public void login() {
		driver.manage().window().maximize();
		driver.get(loginUrl); // 进入登录页
		waitForSecond();

		WebElement element = driver.findElement(By.id("username"));// 找到id名为 uin的dom元素
		element.sendKeys(username);// 当前element为 uin输入框，将用户名填到这个输入框
		waitForSecond(); // 让进程等待一会，避免偶尔出现的元素获取异常
		element = driver.findElement(By.id("password"));
		element.sendKeys(password);// 将密码填入 waitForSecond();
		//element = driver.findElement(By.id("Button1"));// 找到登录按钮
		element = driver.findElement(By.xpath(".//*[@id='Button1']"));// 找到登录按钮
		element.click(); // 点击登录按钮
		waitForSecond2();
	}
	
	// 登录成功后
	public void work() {//
		//WebElement element = driver.findElement(By.xpath("//span[@class='chinese_txt'][2]"));
		//WebElement element = driver.findElement(By.id("mHeaderNav")).findElement(By.linkText("用户中心"));
		WebElement element = driver.findElement(By.xpath(".//*[@id='ntop']/div/div[1]/a/img"));
		element.click(); // 点击按钮
	}

	public void demo() {
		init();
		login();
		work();
		//quitDrvier();
	}

	public static void main(String[] args) {
		MyTest util = new MyTest();
		util.demo();
	}

}
