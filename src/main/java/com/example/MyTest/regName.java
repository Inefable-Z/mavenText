package com.example.MyTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * 手游加盒子
 */
public class regName {
	private String webBrowserPath = "";
	private WebDriver driver = null;
	WebElement element = null;
	String url = "http://www.yy9w.com";
	private String usernameByName = "yy9w123";
	private String password = "123456";
	private String idCard = "511823198401103576";
	private String username = "舒枫瑾";
	String firstWindowHandle = "";

	/*
	 * 注册
	 */
	public void Reg() {
		driver.get(url);
		firstWindowHandle = driver.getWindowHandle();// 获取首页句柄
		waitForSecond(1);
		driver.findElement(By.xpath("html/body/div[1]/div/ul[2]/li[3]/a")).click();
		waitForSecond(2);
		driver.findElement(By.id("regname")).click();
		// driver.findElement(By.xpath("html/body/div[1]/div/ul[2]/li[3]/a")).click();
		driver.findElement(By.id("userNameByName")).sendKeys(usernameByName);
		driver.findElement(By.xpath(".//*[@id='userPass']")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='userConfirmPasss']")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='userIDcard']")).sendKeys(idCard);
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
		waitForSecond(1);
		driver.findElement(By.xpath(".//*[@id='registerByNameSubmit']")).click();
	}

	/*
	 * 下载盒子和游戏
	 */
	public void downLoad() {
		driver.findElement(By.linkText("游戏盒子")).click();
		waitForSecond(2);
		// -------------切换句柄---------------------
		String secondWindowHandle = "";
		Set<String> handles = driver.getWindowHandles();
		for (String string : handles) {
			if (!firstWindowHandle.equals(string)) {
				secondWindowHandle = string;
			}
		}
		driver.switchTo().window(secondWindowHandle);
		// -------------切换句柄end---------------------
		waitForSecond(2);
		driver.findElement(By.xpath(".//*[@id='section0']/div/div/a[1]")).click();
		waitForSecond(1);
		String title = driver.getTitle();
		System.out.println("当前页面的title是：" + title);
		String url = driver.getCurrentUrl();
		System.out.println("当前页面的url是：" + url);
		driver.switchTo().window(firstWindowHandle);// 切换到首页
		driver.findElement(By.xpath(".//*[@id='headerGamecenter']/a")).click();
		// 获取下载游戏元素
		WebElement a = driver.findElement(By.xpath(".//*[@id='gameslist']/li[2]/div/p/a"));
		Actions ac = new Actions(driver);
		ac.moveToElement(a).perform();// 执行鼠标悬停
		waitForSecond(2);
		driver.findElement(By.xpath(".//*[@id='gameslist']/li[2]/div/p/span/a")).click();
		waitForSecond(1);
		System.out.println("下载游戏正常");
	}

	/*
	 * 试玩H5
	 */
	public void H5Test() {
		driver.switchTo().window(firstWindowHandle);// 切换到首页
		driver.findElement(By.linkText("H5游戏")).click();
		driver.findElement(By.xpath(".//*[@id='gameslist']/li[3]/div/p/a")).click();
		driver.findElement(By.xpath(".//*[@id='LoginViewDiv']/div/div/div[1]")).click();
		System.out.println("H5正常试玩");
	}
	/*
	 * 后台登录
	 */
	public void BackStage() {
		
	}

	public void init() {
		webBrowserPath = "D:/Program Files/chromedriverv81.exe";// 谷歌驱动路径
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");// 取消浏览器打印日志
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// 关闭浏览器
	public void quitDrvier() {
		if (null != driver) {
			driver.quit();
		}
	}

	public void waitForSecond(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		init();
		// 注册
		System.out.println("---------------------------start---------------------------");
		Reg();
		// 下载盒子
		downLoad();
		H5Test();
		//quitDrvier();
		System.out.println("---------------------------end---------------------------");
	}

	public static void main(String[] args) {
		regName test = new regName();
		test.start();
	}
}
