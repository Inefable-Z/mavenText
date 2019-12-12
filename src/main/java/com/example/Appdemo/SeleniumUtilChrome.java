package com.example.Appdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * seleunim �����ȸ������
 */
public class SeleniumUtilChrome {
	// ����������·��
	private String webBrowserPath = "";

	private WebDriver driver = null;

	private String loginUrl = "https://platform.xd57.com:5007/login.phtml";// ��¼ҳ
	private String username = "wu37"; // �ʺ�
	private String password = "123456"; // ��������

	
	// ��ʼ�� seleniumҪ���õ������������
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriver.exe";//�ȸ�
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-infobars");
		driver = new ChromeDriver(option);
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

	// ģ���¼����
	public void login() {
		driver.manage().window().maximize();
		driver.get(loginUrl); 
		waitForSecond();
		WebElement element = driver.findElement(By.id("username"));// �ҵ�id��Ϊ uin��dom Ԫ��
		element.sendKeys(username);// ��ǰelementΪ uin����򣬽��û������������
		waitForSecond(); // �ý��̵ȴ�һ�ᣬ����ż�����ֵ�Ԫ�ػ�ȡ�쳣
		element = driver.findElement(By.id("password"));// �ҵ�id��Ϊp�� domԪ��
		element.sendKeys(password);// ����������
		waitForSecond();
		//element = driver.findElement(By.id("info_error"));// �ҵ���¼��ť
		element = driver.findElement(By.xpath("//input[@type='submit']"));// �ҵ���¼��ť
		waitForSecond();
		element.click(); // �����¼��ť
	}
	//��¼�ɹ���
	public void work() {////div[@class='paginatorBatchSizes']/span
		WebElement element = driver.findElement(By.linkText("���"));
		element.click(); // �����ť
	}

	public void demo() {
		init();
		login();
		waitForSecond();
		work();
		//quitDrvier();
	}
	
	public static void main(String[] args) {
		SeleniumUtilChrome util = new SeleniumUtilChrome();
		util.demo();
	}

}
