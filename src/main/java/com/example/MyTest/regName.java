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
 * ���μӺ���
 */
public class regName {
	private String webBrowserPath = "";
	private WebDriver driver = null;
	WebElement element = null;
	String url = "http://www.yy9w.com";
	private String usernameByName = "yy9w123";
	private String password = "123456";
	private String idCard = "511823198401103576";
	private String username = "����";
	String firstWindowHandle = "";

	/*
	 * ע��
	 */
	public void Reg() {
		driver.get(url);
		firstWindowHandle = driver.getWindowHandle();// ��ȡ��ҳ���
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
	 * ���غ��Ӻ���Ϸ
	 */
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
		// -------------�л����end---------------------
		waitForSecond(2);
		driver.findElement(By.xpath(".//*[@id='section0']/div/div/a[1]")).click();
		waitForSecond(1);
		String title = driver.getTitle();
		System.out.println("��ǰҳ���title�ǣ�" + title);
		String url = driver.getCurrentUrl();
		System.out.println("��ǰҳ���url�ǣ�" + url);
		driver.switchTo().window(firstWindowHandle);// �л�����ҳ
		driver.findElement(By.xpath(".//*[@id='headerGamecenter']/a")).click();
		// ��ȡ������ϷԪ��
		WebElement a = driver.findElement(By.xpath(".//*[@id='gameslist']/li[2]/div/p/a"));
		Actions ac = new Actions(driver);
		ac.moveToElement(a).perform();// ִ�������ͣ
		waitForSecond(2);
		driver.findElement(By.xpath(".//*[@id='gameslist']/li[2]/div/p/span/a")).click();
		waitForSecond(1);
		System.out.println("������Ϸ����");
	}

	/*
	 * ����H5
	 */
	public void H5Test() {
		driver.switchTo().window(firstWindowHandle);// �л�����ҳ
		driver.findElement(By.linkText("H5��Ϸ")).click();
		driver.findElement(By.xpath(".//*[@id='gameslist']/li[3]/div/p/a")).click();
		driver.findElement(By.xpath(".//*[@id='LoginViewDiv']/div/div/div[1]")).click();
		System.out.println("H5��������");
	}
	/*
	 * ��̨��¼
	 */
	public void BackStage() {
		
	}

	public void init() {
		webBrowserPath = "D:/Program Files/chromedriverv81.exe";// �ȸ�����·��
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");// ȡ���������ӡ��־
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
		// ע��
		System.out.println("---------------------------start---------------------------");
		Reg();
		// ���غ���
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
