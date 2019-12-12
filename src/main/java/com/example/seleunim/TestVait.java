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
		    // 每隔100毫秒去调用一下until中的函数，默认是0.5秒，如果等待10秒还没有找到元素 。则抛出异常。
		    wait.until(new ExpectedCondition<WebElement>() {
		    	public WebElement apply(WebDriver driver) {
		    		driver.findElement(By.id("kw"));
		    		return driver.findElement(By.id("kw"));
		    		}
		    }).sendKeys("我是一个自动化测试小脚本");
		    } finally {
		    		chrome.close();
		    }
	}
}
