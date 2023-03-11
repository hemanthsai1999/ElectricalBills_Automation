package com.fullTest;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import configuration.PropertiesFile;
import configuration.TakeScreenShots;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElectricalBill_All {
	public static String browserName=null;
	public static String Home=null;
	public static String HomeMotor=null;
	public static String KCP0=null;
	public static String KCPMotor=null;
	public static String KCP1=null;
	public static String KCPShop=null;
	public static String KCP2=null;
	public static String KCP3=null;
	static WebDriver driver = null;
	static TakeScreenShots sc;
	static JavascriptExecutor js;
	public static void main(String[] args) throws Exception {
		PropertiesFile.getProperties();
		sc = new TakeScreenShots();
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
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();
		Test8();
	}

	public static void Test1() throws Exception {
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
		Thread.sleep(1000);
		Thread.sleep(2000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("historyDivbtn")).click();
		Thread.sleep(5000);
		String Paid =driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Paid Date :"+ Paid);
		sc.takeScreenShots("Home",driver);
		//driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
	public static void Test2() throws Exception {
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
		driver.findElement(By.id("ltscno")).sendKeys(HomeMotor);
		driver.findElement(By.id("Billans")).sendKeys(value);
		driver.findElement(By.xpath("//button[@id='Billsignin']")).click();
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
		Thread.sleep(1000);
		Thread.sleep(2000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("historyDivbtn")).click();
		Thread.sleep(5000);
		String Paid =driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Paid Date :"+ Paid);
		sc.takeScreenShots("HomeMotor",driver);
		//driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
	public static void Test3() throws Exception {
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
		driver.findElement(By.id("ltscno")).sendKeys(KCPMotor);
		driver.findElement(By.id("Billans")).sendKeys(value);
		driver.findElement(By.xpath("//button[@id='Billsignin']")).click();
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
		Thread.sleep(1000);
		Thread.sleep(2000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("historyDivbtn")).click();
		Thread.sleep(5000);
		String Paid =driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Paid Date :"+ Paid);
		sc.takeScreenShots("KCP Motor",driver);
		//driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
	public static void Test4() throws Exception {
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
		driver.findElement(By.id("ltscno")).sendKeys(KCP0);
		driver.findElement(By.id("Billans")).sendKeys(value);
		driver.findElement(By.xpath("//button[@id='Billsignin']")).click();
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
		Thread.sleep(1000);
		Thread.sleep(2000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("historyDivbtn")).click();
		Thread.sleep(5000);
		String Paid =driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Paid Date :"+ Paid);
		sc.takeScreenShots("KCP_0",driver);
		//driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
	public static void Test5() throws Exception {
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
		driver.findElement(By.id("ltscno")).sendKeys(KCP1);
		driver.findElement(By.id("Billans")).sendKeys(value);
		driver.findElement(By.xpath("//button[@id='Billsignin']")).click();
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
		Thread.sleep(1000);
		Thread.sleep(2000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("historyDivbtn")).click();
		Thread.sleep(5000);
		String Paid =driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Paid Date :"+ Paid);
		sc.takeScreenShots("KCP_1",driver);
		//driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
	public static void Test6() throws Exception {
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
		driver.findElement(By.id("ltscno")).sendKeys(KCPShop);
		driver.findElement(By.id("Billans")).sendKeys(value);
		driver.findElement(By.xpath("//button[@id='Billsignin']")).click();
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
		Thread.sleep(1000);
		Thread.sleep(2000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("historyDivbtn")).click();
		Thread.sleep(5000);
		String Paid =driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Paid Date :"+ Paid);
		sc.takeScreenShots("KCP Shop",driver);
		//driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
	public static void Test7() throws Exception {
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
		driver.findElement(By.id("ltscno")).sendKeys(KCP2);
		driver.findElement(By.id("Billans")).sendKeys(value);
		driver.findElement(By.xpath("//button[@id='Billsignin']")).click();
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
		Thread.sleep(1000);
		Thread.sleep(8000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("historyDivbtn")).click();
		Thread.sleep(5000);
		String Paid =driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Paid Date :"+ Paid);
		sc.takeScreenShots("KCP_2",driver);
		//driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
	public static void Test8() throws Exception {
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
		driver.findElement(By.id("ltscno")).sendKeys(KCP3);
		driver.findElement(By.id("Billans")).sendKeys(value);
		driver.findElement(By.xpath("//button[@id='Billsignin']")).click();
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
		Thread.sleep(1000);
		Thread.sleep(2000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("historyDivbtn")).click();
		Thread.sleep(5000);
		String Paid =driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Paid Date :"+ Paid);
		sc.takeScreenShots("KCP_3",driver);
		//driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		driver.close();
	}
	

}
