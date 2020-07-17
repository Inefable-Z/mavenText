package com.example.MyTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * ���μӺ���
 */
public class regName {
	private String webBrowserPath = "";
	private WebDriver driver = null;
	WebElement element = null;
	String url = "http://3hinet.95php.com";
	private String usernameByName = "3333hhhh";
	private String password = "123456";
	private String idCard = "511823198401103576";
	private String username = "����";
	String firstWindowHandle = "";

	/*
	 * ע��
	 */
	public void Reg() {
		driver.get(url);
		firstWindowHandle = driver.getWindowHandle();// ��ȡ���
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

	public void downLoad() {
		driver.findElement(By.linkText("��Ϸ����")).click();
		waitForSecond(2);
		// -------------�л����---------------------
		String secondWindowHandle = "";
		Set<String> handles = driver.getWindowHandles();
		for (String string : handles) {
			if (!firstWindowHandle.equals(string)) {
				secondWindowHandle = string;
			}
		}
		driver.switchTo().window(secondWindowHandle);
		// -------------�л����---------------------
		waitForSecond(2);
		driver.findElement(By.xpath(".//*[@id='section0']/div/div/a[2]")).click();
		waitForSecond(1);
		driver.switchTo().window(firstWindowHandle);// �л�����һ��ҳ��
		driver.findElement(By.xpath(".//*[@id='headerGamecenter']/a")).click();
	}

	public void init() {
		webBrowserPath = "D:/Program Files/chromedriverv81.exe";// �ȸ�����·��
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");//ȡ���������ӡ��־
		driver = new ChromeDriver();
		driver.manage().window().maximize();
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
		//ע��
		System.out.println("---------------------------start---------------------------");
		Boolean regFlag = false;
		for(int i=0; i< 1; i++) {
			Reg();
			regFlag = true;
		}
		if (regFlag = true) {
			System.err.println("ע������");
		}
		//���غ���
		Boolean downFlag = false;
		for(int i=0; i< 1; i++) {
			downLoad();
			downFlag = true;
		}
		if (downFlag = true) {
			System.err.println("��������");
		}
		quitDrvier();
		System.out.println("---------------------------end---------------------------");
	}

	public static void main(String[] args) {
		regName test = new regName();
		test.start();
	}
}