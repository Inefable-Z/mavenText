package com.example.MyTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {
	public static void main(String[] args) {

		System.setProperty("webdriver.firefox.bin", "E:\\FireFox\\firefox.exe");
		System.setProperty("webdriver.firefox.marionette", "D:\\Program Files\\geckodriver.exe");
		// ��ʼ��һ����������ʵ����ʵ�����ƽ�driver
		WebDriver driver = new FirefoxDriver();
		// ��󻯴���
		driver.manage().window().maximize();
		// �������Եȴ�ʱ��
		//driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// get()��һ��վ��
		driver.get("https://fanyi.qq.com/?ADTAG=feedsdh");
		// getTitle()��ȡ��ǰҳ��title��ֵ

		WebElement element = driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div[1]/div[1]/textarea"));
		element.click();
		element.sendKeys("���Է���");
		//element = driver.findElement(By.xpath("html/body/div[1]/div/div/div[5]/a[2]"));
		driver.findElement(By.linkText("��Ʒ����")).click();
		// �رղ��˳������
		//driver.quit();

	}
}
