package com.example.MyTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * seleunim �����ȸ������
 */
public class TestChandao {
	// ����������·��
	private String webBrowserPath = "";

	private WebDriver driver = null;

	private String loginUrl = "http://demo.zentao.net/user-login.html";// ��¼ҳ
	private String username = "demo"; // �ʺ�
	private String password = "123456"; // ����

	
	// ��ʼ�� seleniumҪ���õ������������
	public void init() {
		webBrowserPath = "D:/Program Files/chromedriver.exe";//�ȸ�
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

	// ģ���¼����
	public void login() {
		driver.get(loginUrl); // ����QQ��¼ҳ
		WebElement element = driver.findElement(By.id("account"));// �ҵ�id��Ϊ uin��dom Ԫ��
		element.clear();
		element.sendKeys(username);// ��ǰelementΪ uin����򣬽��û������������
		waitForSecond(); // �ý��̵ȴ�һ�ᣬ����ż�����ֵ�Ԫ�ػ�ȡ�쳣
		element = driver.findElement(By.xpath(".//*[@id='loginPanel']/div/div[2]/form/table/tbody/tr[2]/td/input"));// �ҵ�id��Ϊp�� domԪ��
		element.clear();
		element.sendKeys(password);// ����������
		waitForSecond();
		element = driver.findElement(By.xpath(".//*[@id='submit']"));// �ҵ���¼��ť
		element.click(); // �����¼��ť
		waitForSecond();
		//------------------------------------------------------------------------------
		//driver.getWindowHandle();
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a")).click();
		driver.findElement(By.xpath(".//*[@id='subNavbar']/ul/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='mainMenu']/div[3]/a[3]")).click();
		//������Ʒ
		driver.findElement(By.xpath(".//*[@id='product_chosen']/a/span")).click();
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='product_chosen']/div/ul/li[3]")).click();
		//����ģ��
		driver.findElement(By.xpath(".//*[@id='module_chosen']/a/span")).click();
		waitForSecond();
		//driver.findElement(By.xpath(".//*[@id='module_chosen']/div/ul/li[1]")).click();
		//��������
		driver.findElement(By.xpath(".//*[@id='project_chosen']/a/span")).click();
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='project_chosen']/div/ul/li")).click();
		waitForSecond();
		//Ӱ��汾
		driver.findElement(By.xpath(".//*[@id='openedBuild_chosen']/ul")).click();
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='openedBuild_chosen']/div/ul/li")).click();
		waitForSecond();
		//��ǰָ��
		/*
		 * driver.findElement(By.xpath(".//*[@id='assignedTo_chosen']/a/div[2]/input")).
		 * click(); waitForSecond();
		 * driver.findElement(By.xpath(".//*[@id='assignedTo_chosen']/div/ul/li[1]")).
		 * click(); waitForSecond();
		 */
	
		driver.findElement(By.xpath(".//*[@id='title']")).sendKeys("ħ�У�ģ��1");
		waitForSecond();
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		String title = driver.getTitle();
		//System.out.println(title);
	}
	//��¼�ɹ���
	public void work() {
		WebElement element = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a"));
		element.click(); 
		element = driver.findElement(By.xpath(".//*[@id='subNavbar']/ul/li[1]/a"));
		element.click(); 
		element = driver.findElement(By.xpath(".//*[@id='mainMenu']/div[3]/a[3]"));
		element.click(); 
		element = driver.findElement(By.xpath(".//*[@id='title']"));
		element.sendKeys("����");
		waitForSecond();
		element = driver.findElement(By.xpath(".//*[@id='submit']"));
		element.click(); 
	}

	public void demo() {
		init();
		login();
		//work();
		//quitDrvier();
	}
	
	public static void main(String[] args) {
		TestChandao chandao = new TestChandao();
		chandao.demo();
	}

}
