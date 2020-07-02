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
	      //��ȡ��ǰ�� title �� url
	      System.out.printf("title of current page is %s\n", driver.getTitle());
	      System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
	      //�ٶ�����
	      WebElement search = driver.findElement(By.id("kw"));
	      search.sendKeys("Selenium");
	      search.sendKeys(Keys.ENTER);
	      waitForSecond(2);	 
	      System.out.println("Search after================");
	 
	      //��ȡ��ǰ�� title �� url
	      System.out.printf("title of current page is %s\n", driver.getTitle());
	      System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
	 
	      //��ȡ��һ����������ı���
	      WebElement result = driver.findElement(By.xpath("//div[@id='content_left']/div/h3/a"));
	      System.out.println(result.getText());
	      
	      //��ȡԪ������
	      Point aaa = driver.findElement(By.xpath(".//*[@id='container']/div[2]/div/div[2]/div")).getLocation();
	      System.out.println(aaa);
	      
	      //��ȡԪ�ص�����ֵ
	      String aaaa = driver.findElement(By.id("su")).getAttribute("value");
	      System.out.println(aaaa);
	      
	      //����Ԫ�صĴ�С �߶� ���
	      Dimension width_height = driver.findElement(By.id("su")).getSize();
	      System.out.println("�߶ȣ�"+width_height.height + " ���: " + width_height.width);
	      
	      //�ж�Ԫ���Ƿ���ʾ
	      boolean flag =  driver.findElement(By.id("su")).isDisplayed();
	      System.out.println(flag);
	      
	      //����Ԫ�ص�tagName
	      String tname =  driver.findElement(By.id("su")).getTagName();
	      System.out.println(tname);
	      
	      //ɾ����������е�Cookies
	      driver.manage().deleteAllCookies();
	      
	      //����� ǰ������ˢ��
	      driver.navigate().forward();
	      driver.navigate().back();
	      driver.navigate().refresh();
	       */
	      
	      //���õȴ���ʱ
	      driver.manage().timeouts();
	      driver.quit();

		
	}
	
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriverv81.exe";// �ȸ�����·��
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
