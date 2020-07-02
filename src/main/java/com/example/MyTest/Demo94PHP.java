package com.example.MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Demo94PHP{
	private String webBrowserPath = "";
	private WebDriver driver = null;
	String url = "http://demo.94php.com/admin";
	String username = "admin";
	String pwd = "kyzh123456";

	public void add() {
		// login();//�ж�session�����¼��Ϣ��������ִ��login����
		waitForSecond(3);
		driver.findElement(By.xpath(".//*[@id='nav_class']/li[2]/i")).click();// ��Ϸһ��
		driver.findElement(By.xpath(".//*[@id='nav_class']/li[2]/i")).click();// ��Ϸһ��
		driver.findElement(By.xpath(".//*[@id='nav_list']/li[1]/a/span")).click();// ���ι���
		driver.findElement(By.xpath(".//*[@id='nav_list']/li[1]/ul/li[1]/a")).click();// ������Ϸ

		driver.findElement(By.xpath(".//*[@id='form1']/table/tbody/tr[10]/td[12]/a[1]")).click();// ����
		waitForSecond(2);
		// ����������
		WebElement selector = driver.findElement(By.name("type"));
		Select select = new Select(selector);
		select.deselectByValue("9");
		waitForSecond(2);
		driver.findElement(By.xpath("html/body/div[1]/div/form/div[1]/div[16]/div[1]/input")).sendKeys("15989");
	}

	public void init() {
		/*
		 * ChromeOptions options = new ChromeOptions(); options.
		 * addArguments("--user-data-dir=C:\\Users\\EDZ\\AppData\\Local\\Google\\Chrome\\User Data"
		 * ); System.setProperty("webdriver.chrome.driver",
		 * "D:/Program Files/chromedriverv81.exe"); WebDriver driver = new
		 * ChromeDriver(options);
		 */
		webBrowserPath = "D:/Program Files/chromedriverv81.exe";// �ȸ�����·��
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
	}

	// �ر������
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
		add();
	}

	public static void main(String[] args) {
		Demo94PHP d94 = new Demo94PHP();
		d94.start();
	}
}
