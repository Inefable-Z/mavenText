package com.example.MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuanYan {
	private String webBrowserPath = "";
	private WebDriver driver = null;
	WebElement element = null;
	
	public void test() {
	      driver.get("https://www.baidu.com");
	      /*
	      System.out.println("Search before================");
	      //获取当前的 title 和 url
	      System.out.printf("title of current page is %s\n", driver.getTitle());
	      System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
	      //百度搜索
	      WebElement search = driver.findElement(By.id("kw"));
	      search.sendKeys("Selenium");
	      search.sendKeys(Keys.ENTER);
	      waitForSecond(2);	 
	      System.out.println("Search after================");
	 
	      //获取当前的 title 和 url
	      System.out.printf("title of current page is %s\n", driver.getTitle());
	      System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
	 
	      //获取第一条搜索结果的标题
	      WebElement result = driver.findElement(By.xpath("//div[@id='content_left']/div/h3/a"));
	      System.out.println(result.getText());
	      
	      //获取元素坐标
	      Point aaa = driver.findElement(By.xpath(".//*[@id='container']/div[2]/div/div[2]/div")).getLocation();
	      System.out.println(aaa);
	      
	      //获取元素的属性值
	      String aaaa = driver.findElement(By.id("su")).getAttribute("value");
	      System.out.println(aaaa);
	      
	      //返回元素的大小 高度 宽度
	      Dimension width_height = driver.findElement(By.id("su")).getSize();
	      System.out.println("高度："+width_height.height + " 宽度: " + width_height.width);
	      
	      //判断元素是否显示
	      boolean flag =  driver.findElement(By.id("su")).isDisplayed();
	      System.out.println(flag);
	      
	      //返回元素的tagName
	      String tname =  driver.findElement(By.id("su")).getTagName();
	      System.out.println(tname);
	      
	      //删除浏览器所有的Cookies
	      driver.manage().deleteAllCookies();
	      
	      //浏览器 前进后退刷新
	      driver.navigate().forward();
	      driver.navigate().back();
	      driver.navigate().refresh();
	       */
	      
	      //设置等待超时
	      driver.manage().timeouts();
	      driver.quit();

		
	}
	
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriverv81.exe";// 谷歌驱动路径
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
	}
	
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
		test();
	}
	
	public static void main(String[] args) {
		DuanYan u= new DuanYan();
		u.start();
	}
}
