package com.example.MyTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class regName {
	private String webBrowserPath = "";
	private WebDriver driver = null;
	WebElement element = null;
	String url = "http://shouyou.94php.com/";
	private String usernameByName = "9288wan123";
	private String password = "123456";
	private String idCard = "511823198401103576";
	private String username = "Êæ·ãèª";
	String firstWindowHandle = "";
	
	/*
	 * ×¢²á
	 */
	public void Reg() {
		driver.get(url);
		firstWindowHandle = driver.getWindowHandle();//»ñÈ¡¾ä±ú
		waitForSecond(1);
		driver.findElement(By.xpath("html/body/div[1]/div/ul[2]/li[3]/a")).click();
		waitForSecond(2);
		driver.findElement(By.id("regname")).click();
		//driver.findElement(By.xpath("html/body/div[1]/div/ul[2]/li[3]/a")).click();
		driver.findElement(By.id("userNameByName")).sendKeys(usernameByName);
		driver.findElement(By.xpath(".//*[@id='userPass']")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='userConfirmPasss']")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='userIDcard']")).sendKeys(idCard);
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
		waitForSecond(1);
		driver.findElement(By.xpath(".//*[@id='registerByNameSubmit']")).click();
	}
	
	public void downLoad() {
		driver.findElement(By.xpath(".//*[@id='mHeaderNav']/li[7]/a")).click();
		waitForSecond(2);
		//-------------ÇÐ»»¾ä±ú---------------------
		String secondWindowHandle = "";
        Set<String> handles = driver.getWindowHandles();
        for (String string : handles) {
              if (!firstWindowHandle.equals(string)) {
                    secondWindowHandle = string;
              }
        }
        driver.switchTo().window(secondWindowHandle);
        //-------------ÇÐ»»¾ä±ú---------------------
        waitForSecond(2);
        driver.findElement(By.xpath(".//*[@id='section0']/div/div/a[2]")).click();
        waitForSecond(1);
        driver.switchTo().window(firstWindowHandle);//ÇÐ»»µ½µÚÒ»¸öÒ³Ãæ
        driver.findElement(By.xpath(".//*[@id='headerGamecenter']/a")).click();
	}
	
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriverv81.exe";// ¹È¸èÇý¶¯Â·¾¶
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// ¹Ø±Õä¯ÀÀÆ÷
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
		Reg();
		waitForSecond(1);
		downLoad();
	}
	public static void main(String[] args) {
		regName test = new regName();
		test.start();
	}
}
