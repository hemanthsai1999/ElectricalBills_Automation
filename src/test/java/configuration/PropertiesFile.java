package configuration;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.fullTest.ElectricalBill;
import com.fullTest.ElectricalBill_All;
import com.testng.ElectricalBill_TestNG;

public class PropertiesFile {

	public static void main(String[] args) {
		getProperties();
	}

	public static void getProperties() {
		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("C:\\Users\\Hemanth Sai Dadi\\eclipse-testspace\\ElectricalBill\\src\\test\\java\\configuration\\config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("Browser"));
			ElectricalBill.browserName=prop.getProperty("Browser");
			ElectricalBill.Home=prop.getProperty("KCP2");
			ElectricalBill_TestNG.browserName=prop.getProperty("Browser");
			ElectricalBill_TestNG.Home=prop.getProperty("KCP2");
			ElectricalBill_All.browserName=prop.getProperty("Browser");
			ElectricalBill_All.Home=prop.getProperty("Home");
			ElectricalBill_All.HomeMotor=prop.getProperty("HomeMotor");
			ElectricalBill_All.KCPMotor=prop.getProperty("KCPMotor");
			ElectricalBill_All.KCP0=prop.getProperty("KCP0");
			ElectricalBill_All.KCP1=prop.getProperty("KCP1");
			ElectricalBill_All.KCPShop=prop.getProperty("KCPShop");
			ElectricalBill_All.KCP2=prop.getProperty("KCP2");
			ElectricalBill_All.KCP3=prop.getProperty("KCP3");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}