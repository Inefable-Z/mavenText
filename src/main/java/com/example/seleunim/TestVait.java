package com.example.seleunim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestVait {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Program Files/chromedriver.exe");
		ChromeDriver chrome = new ChromeDriver();
		
		try {
		    WebDriverWait wait = new WebDriverWait(chrome, 10, 100);
		    // ÿ��100����ȥ����һ��until�еĺ�����Ĭ����0.5�룬����ȴ�10�뻹û���ҵ�Ԫ�� �����׳��쳣��
		    wait.until(new ExpectedCondition<WebElement>() {
		    	public WebElement apply(WebDriver driver) {
		    		driver.findElement(By.id("kw"));
		    		return driver.findElement(By.id("kw"));
		    		}
		    }).sendKeys("����һ���Զ�������С�ű�");
		    } finally {
		    		chrome.close();
		    }
	}
}
