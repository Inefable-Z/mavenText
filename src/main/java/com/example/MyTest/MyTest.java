package com.example.MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * seleunim �����ȸ������
 */
public class MyTest {
	// ����������·��
	private String webBrowserPath = "";

	private WebDriver driver = null;

	private String loginUrl = "http://webgame.94php.com/index.html";// ��¼ҳ
	private String username = "123456"; // �ʺ�
	private String password = "123456"; // ����

	// ��ʼ�� seleniumҪ���õ������������
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriver.exe";// �ȸ�
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		driver = new ChromeDriver();
	}

	// �ر������
	public void quitDrvier() {
		if (null != driver) {
			driver.quit();
		}
	}

	public void waitForSecond() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void waitForSecond2() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ģ���¼����
	public void login() {
		driver.manage().window().maximize();
		driver.get(loginUrl); // �����¼ҳ
		waitForSecond();

		WebElement element = driver.findElement(By.id("username"));// �ҵ�id��Ϊ uin��domԪ��
		element.sendKeys(username);// ��ǰelementΪ uin����򣬽��û������������
		waitForSecond(); // �ý��̵ȴ�һ�ᣬ����ż�����ֵ�Ԫ�ػ�ȡ�쳣
		element = driver.findElement(By.id("password"));
		element.sendKeys(password);// ���������� waitForSecond();
		//element = driver.findElement(By.id("Button1"));// �ҵ���¼��ť
		element = driver.findElement(By.xpath(".//*[@id='Button1']"));// �ҵ���¼��ť
		element.click(); // �����¼��ť
		waitForSecond2();
	}
	
	// ��¼�ɹ���
	public void work() {//
		//WebElement element = driver.findElement(By.xpath("//span[@class='chinese_txt'][2]"));
		//WebElement element = driver.findElement(By.id("mHeaderNav")).findElement(By.linkText("�û�����"));
		WebElement element = driver.findElement(By.xpath(".//*[@id='ntop']/div/div[1]/a/img"));
		element.click(); // �����ť
	}

	public void demo() {
		init();
		login();
		work();
		//quitDrvier();
	}

	public static void main(String[] args) {
		MyTest util = new MyTest();
		util.demo();
	}

}
