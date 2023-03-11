package configuration;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShots {
	
	public void takeScreenShots(String fileName,WebDriver driver) throws Exception {
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Hemanth Sai Dadi\\eclipse-workspace\\ElectricalBill\\Screenshots\\"+fileName+".jpg"));
		
	}

}
