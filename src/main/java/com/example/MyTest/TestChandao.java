package com.example.MyTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * seleunim 启动谷歌浏览器
 */
public class TestChandao {
	// 浏览器程序的路径
	private String webBrowserPath = "";

	private WebDriver driver = null;

	private String loginUrl = "http://demo.zentao.net/user-login.html";// 登录页
	private String username = "demo"; // 帐号
	private String password = "123456"; // 密码

	
	// 初始化 selenium要调用的浏览器并启动
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriver.exe";//谷歌
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// 关闭浏览器
	public void quitDrvier() {
		if (null != driver) {
			driver.quit();
		}
	}

	public void waitForSecond() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 模拟登录过程
	public void login() {
		driver.get(loginUrl); // 进入QQ登录页
		WebElement element = driver.findElement(By.id("account"));// 找到id名为 uin的dom 元素
		element.clear();
		element.sendKeys(username);// 当前element为 uin输入框，将用户名填到这个输入框
		waitForSecond(); // 让进程等待一会，避免偶尔出现的元素获取异常
		element = driver.findElement(By.xpath(".//*[@id='loginPanel']/div/div[2]/form/table/tbody/tr[2]/td/input"));// 找到id名为p的 dom元素
		element.clear();
		element.sendKeys(password);// 将密码填入
		waitForSecond();
		element = driver.findElement(By.xpath(".//*[@id='submit']"));// 找到登录按钮
		element.click(); // 点击登录按钮
		waitForSecond();
		//------------------------------------------------------------------------------
		//driver.getWindowHandle();
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a")).click();
		driver.findElement(By.xpath(".//*[@id='subNavbar']/ul/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='mainMenu']/div[3]/a[3]")).click();
		//所属产品
		driver.findElement(By.xpath(".//*[@id='product_chosen']/a/span")).click();
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='product_chosen']/div/ul/li[3]")).click();
		//所属模块
		driver.findElement(By.xpath(".//*[@id='module_chosen']/a/span")).click();
		waitForSecond();
		//driver.findElement(By.xpath(".//*[@id='module_chosen']/div/ul/li[1]")).click();
		//所属迭代
		driver.findElement(By.xpath(".//*[@id='project_chosen']/a/span")).click();
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='project_chosen']/div/ul/li")).click();
		waitForSecond();
		//影响版本
		driver.findElement(By.xpath(".//*[@id='openedBuild_chosen']/ul")).click();
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='openedBuild_chosen']/div/ul/li")).click();
		waitForSecond();
		//当前指派
		/*
		 * driver.findElement(By.xpath(".//*[@id='assignedTo_chosen']/a/div[2]/input")).
		 * click(); waitForSecond();
		 * driver.findElement(By.xpath(".//*[@id='assignedTo_chosen']/div/ul/li[1]")).
		 * click(); waitForSecond();
		 */
	
		driver.findElement(By.xpath(".//*[@id='title']")).sendKeys("魔盒，模块1");
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		String title = driver.getTitle();
		//System.out.println(title);
	}
	//登录成功后
	public void work() {
		WebElement element = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a"));
		element.click(); 
		element = driver.findElement(By.xpath(".//*[@id='subNavbar']/ul/li[1]/a"));
		element.click(); 
		element = driver.findElement(By.xpath(".//*[@id='mainMenu']/div[3]/a[3]"));
		element.click(); 
		element = driver.findElement(By.xpath(".//*[@id='title']"));
		element.sendKeys("测试");
		waitForSecond();
		element = driver.findElement(By.xpath(".//*[@id='submit']"));
		element.click(); 
	}

	public void demo() {
		init();
		login();
		//work();
		//quitDrvier();
	}
	
	public static void main(String[] args) {
		TestChandao chandao = new TestChandao();
		chandao.demo();
	}

}
