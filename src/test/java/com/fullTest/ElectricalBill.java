package com.fullTest;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import configuration.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElectricalBill {
	public static String browserName=null;
	public static String Home=null;
	static WebDriver driver = null;
	static WebDriver newdriver = null;

	public static void main(String[] args) throws Exception {
		PropertiesFile.getProperties();
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		Login();
		Details();
		PaymentHistory();
		LatestBill();

	}

	public static void Login() throws Exception {
		driver.get("https://www.apeasternpower.com/payBillOnline");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div[2]/ul/li[9]/a")).click();
		String Element =driver.findElement(By.id("Billquestion")).getText();
		String parent = driver.getWindowHandle();
		//New Window
		WebDriver newdriver= driver.switchTo().newWindow(WindowType.TAB);
		newdriver.get("https://www.google.com/");
		WebElement element = newdriver.findElement(By.name("q"));
		element.sendKeys(Element);
		element.submit();
		String value =newdriver.findElement(By.id("cwos")).getText();
		newdriver.close();
		//Back to old Window
		driver.switchTo().window(parent);
		driver.findElement(By.id("ltscno")).sendKeys(Home);
		driver.findElement(By.id("Billans")).sendKeys(value);
		driver.findElement(By.xpath("//button[@id='Billsignin']")).click();
	}

	public static void Details() throws Exception {
		Thread.sleep(5000);
		String ServiceNumber = driver.findElement(By.xpath(".//*[@id='listdata']/div[1]/div/div/div/div/div/div/div[3]/div[1]/table/tbody/tr[1]/td[2]")).getText();
		String ConsumerName = driver.findElement(By.xpath(".//*[@id='listdata']/div[1]/div/div/div/div/div/div/div[3]/div[1]/table/tbody/tr[2]/td[2]")).getText();
		if(ServiceNumber.equals("1111141457008903")) {
			System.out.println("Home");
		}
		if(ServiceNumber.equals("1111141457123781")) {
			System.out.println("HomeMotor");
		}
		if(ServiceNumber.equals("1111141457351868")) {
			System.out.println("KCPMotor");
		}
		if(ServiceNumber.equals("1111141457089817")) {
			System.out.println("KCP 0");
		}
		if(ServiceNumber.equals("1111141457340956")) {
			System.out.println("KCP 1");
		}
		if(ServiceNumber.equals("1111141457351869")) {
			System.out.println("KCP Shop");
		}
		if(ServiceNumber.equals("1111141457089395")) {
			System.out.println("KCP 2");
		}
		if(ServiceNumber.equals("1111141457341987")) {
			System.out.println("KCP 3");
		}
		System.out.println("ServiceNumber :"+ServiceNumber);
		System.out.println("ConsumerName :"+ConsumerName);
	}

	public static void  PaymentHistory() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("historyDivbtn")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'PDF Download')]")).click();
	}

	public static void LatestBill() throws Exception {
		Thread.sleep(5000);
		String Paid =driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Paid Date :"+ Paid);
		//driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		driver.close();
	}


}
