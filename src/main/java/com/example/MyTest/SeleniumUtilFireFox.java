package com.example.MyTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
/*
 * seleunim �����ȸ������
 */
public class SeleniumUtilFireFox {
	// ����������·��
	private String webBrowserPath = "";

	private WebDriver driver = null;

	private String loginUrl = "https://platform.xd57.com:5007/login.phtml";// ��¼ҳ
	private String username = "wu37"; // �ʺ�
	private String password = "123456"; // ����

	
	// ��ʼ�� seleniumҪ���õ������������
	public void init() {
		System.setProperty("webdriver.firefox.marionette", "D:\\Program Files\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "E:\\FireFox\\firefox.exe");
		driver = new FirefoxDriver();
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
		driver.get(loginUrl); // ����QQ��¼ҳ
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
		WebElement element = driver.findElement(By.xpath(""));
		element.click(); // �����ť
	}

	public void demo() {
		init();
		login();
		//work();
		//quitDrvier();
	}
	
	public static void main(String[] args) {
		SeleniumUtilFireFox util = new SeleniumUtilFireFox();
		util.demo();
	}

}
