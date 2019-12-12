package com.example.MyTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {
	public static void main(String[] args) {

		System.setProperty("webdriver.firefox.bin", "E:\\FireFox\\firefox.exe");
		System.setProperty("webdriver.firefox.marionette", "D:\\Program Files\\geckodriver.exe");
		// 初始化一个火狐浏览器实例，实例名称叫driver
		WebDriver driver = new FirefoxDriver();
		// 最大化窗口
		driver.manage().window().maximize();
		// 设置隐性等待时间
		//driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// get()打开一个站点
		driver.get("https://fanyi.qq.com/?ADTAG=feedsdh");
		// getTitle()获取当前页面title的值

		WebElement element = driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div[1]/div[1]/textarea"));
		element.click();
		element.sendKeys("测试翻译");
		//element = driver.findElement(By.xpath("html/body/div[1]/div/div/div[5]/a[2]"));
		driver.findElement(By.linkText("产品介绍")).click();
		// 关闭并退出浏览器
		//driver.quit();

	}
}
