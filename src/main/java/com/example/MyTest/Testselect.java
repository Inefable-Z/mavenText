package com.example.MyTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testselect {
	// 浏览器程序的路径
	private String webBrowserPath = "";

	private WebDriver driver = null;

	private String loginUrl = "http://demo.zentao.net/user-login.html";// 登录页
	private String username = "demo"; // 帐号
	private String password = "123456"; // 密码

	// 初始化 selenium要调用的浏览器并启动
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriver.exe";// 谷歌
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

	public void login() {
		String firstWindowHandle = driver.getWindowHandle();
		driver.get(loginUrl); // 进入QQ登录页
		WebElement element = driver.findElement(By.id("account"));// 找到id名为 uin的dom 元素
		element.clear();
		element.sendKeys(username);// 当前element为 uin输入框，将用户名填到这个输入框
		waitForSecond(); // 让进程等待一会，避免偶尔出现的元素获取异常
		element = driver.findElement(By.xpath(".//*[@id='loginPanel']/div/div[2]/form/table/tbody/tr[2]/td/input"));// 找到id名为p的
																													// dom元素
		element.clear();
		element.sendKeys(password);// 将密码填入
		waitForSecond();
		element = driver.findElement(By.xpath(".//*[@id='submit']"));// 找到登录按钮
		element.click(); // 点击登录按钮
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a")).click();
		driver.findElement(By.xpath(".//*[@id='subNavbar']/ul/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='mainMenu']/div[3]/a[3]")).click();
		// 元素隐藏 修改css使其可以操作
		System.out.println("aaaa");
		// 打印出所有选项值
		driver.findElement(By.xpath(".//*[@id='assignedTo_chosen']/a/span")).click();
		waitForSecond();
		String inputName = "document.getElementById('assignedTo').style.display='block';";
		JavascriptExecutor js = (JavascriptExecutor) driver;// 只可放在方法内
		js.executeScript(inputName);
		//driver.findElement(By.xpath("//option[@value='tester1']")).click();无效
	}

	public void testStr() {

		/*
		 * Select select = new
		 * Select(driver.findElement(By.xpath("//select[@id='assignedTo']")));
		 * 
		 * select.selectByIndex(2); List<WebElement> options = select.getOptions(); for
		 * (WebElement option : options) { System.out.println(option.getText()); }
		 */

	}

	public void demo() {
		init();
		login();
		testStr();
	}

	public static void main(String[] args) {
		Testselect tet = new Testselect();
		tet.demo();
	}
}
