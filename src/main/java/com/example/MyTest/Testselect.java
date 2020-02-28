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
	// ����������·��
	private String webBrowserPath = "";

	private WebDriver driver = null;

	private String loginUrl = "http://demo.zentao.net/user-login.html";// ��¼ҳ
	private String username = "demo"; // �ʺ�
	private String password = "123456"; // ����

	// ��ʼ�� seleniumҪ���õ������������
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriver.exe";// �ȸ�
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// �ر������
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
		driver.get(loginUrl); // ����QQ��¼ҳ
		WebElement element = driver.findElement(By.id("account"));// �ҵ�id��Ϊ uin��dom Ԫ��
		element.clear();
		element.sendKeys(username);// ��ǰelementΪ uin����򣬽��û������������
		waitForSecond(); // �ý��̵ȴ�һ�ᣬ����ż�����ֵ�Ԫ�ػ�ȡ�쳣
		element = driver.findElement(By.xpath(".//*[@id='loginPanel']/div/div[2]/form/table/tbody/tr[2]/td/input"));// �ҵ�id��Ϊp��
																													// domԪ��
		element.clear();
		element.sendKeys(password);// ����������
		waitForSecond();
		element = driver.findElement(By.xpath(".//*[@id='submit']"));// �ҵ���¼��ť
		element.click(); // �����¼��ť
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a")).click();
		driver.findElement(By.xpath(".//*[@id='subNavbar']/ul/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='mainMenu']/div[3]/a[3]")).click();
		// Ԫ������ �޸�cssʹ����Բ���
		System.out.println("aaaa");
		// ��ӡ������ѡ��ֵ
		driver.findElement(By.xpath(".//*[@id='assignedTo_chosen']/a/span")).click();
		waitForSecond();
		String inputName = "document.getElementById('assignedTo').style.display='block';";
		JavascriptExecutor js = (JavascriptExecutor) driver;// ֻ�ɷ��ڷ�����
		js.executeScript(inputName);
		//driver.findElement(By.xpath("//option[@value='tester1']")).click();��Ч
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
