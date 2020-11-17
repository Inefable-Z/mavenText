package com.example.MyTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

public class BaiduYunTest {
	private String webBrowserPath = "";
	private WebDriver driver = null;
	WebElement element = null;

	public void startone(){
		driver.get("https://pan.baidu.com/");
		waitForSecond(1);
		driver.findElement(By.xpath(".//*[@id='pass_phoenix_btn']/ul/li[2]/a")).click();
		waitForSecond(1);

		// ��ȡ��ǰҳ����
		String handle = driver.getWindowHandle();
		// ��ȡ����ҳ��ľ������ѭ���жϲ��ǵ�ǰ�ľ�� Ȼ���л����Ӵ���
		for (String handles : driver.getWindowHandles()) {
			if (handles.equals(handle))
				continue;
			driver.switchTo().window(handles);
		}
		// ���ڵ�¼�������frame�У�����Ҫ���л�����frame������Ҳ�Ҳ���������
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ptlogin_iframe']")));
		// ���Թ����У������ʾ�Ҳ���Ԫ�أ���֪���Ƿ��л��ɹ��ˣ����԰ѵ�ǰhandler��source��ӡ��������
		//System.out.println(driver.getPageSource());
		
		driver.findElement(By.xpath("//*[@id='switcher_plogin']")).click();
		driver.findElement(By.xpath("//*[@id='u']")).sendKeys("1070710800");
        driver.findElement(By.xpath("//*[@id='p']")).sendKeys("mhz1070710800+.+");
        driver.findElement(By.xpath("//*[@id='login_button']")).click();
        //driver.close();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.accept();
        
        driver.findElement(By.xpath(".//*[@id='dialog1']/div[1]/div/span")).click();
        
        WebElement tuichu = driver.findElement(By.xpath(".//*[@id='layoutHeader']/div/div/dl/dd[2]/span/i"));
        Actions ac = new Actions(driver);
        ac.moveToElement(tuichu).perform();//�����ͣ����ť
        waitForSecond(1);
        driver.findElement(By.xpath(".//*[@id='layoutHeader']/div/div/dl/dd[2]/span/dl/dd/ul/li[6]/a")).click();
	}

	public void init() {
		webBrowserPath = "D:/Program Files/chromedriverv81.exe";// �ȸ�����·��
		System.setProperty("webdriver.chrome.driver", webBrowserPath);
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");// ȡ���������ӡ��־
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		startone();
	}

	public static void main(String[] args) {
		BaiduYunTest bdy = new BaiduYunTest();
		bdy.start();
	}
}
