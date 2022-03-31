package reusable;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.Status;

import base.Base;

public class Reusable extends Base
{

	public void screenshot(String ScreenShot) throws Exception
	{


		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Smallscreenshot\\"+ScreenShot));


		/*Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(),"jpg",new File("C:\\Smallscreenshot\\"+screenshot)); */

	}
	public void  validate()
	{
		String str = driver.findElement(By.id("menu_dashboard_index")).getText();
		if(str.contains("Dashboard"))
		{
			exttest.log(Status.PASS,"Login is successfull" );
		}
		else
		{
			exttest.log(Status.FAIL,"Login failed" );
			//Reporter.log("<font color='red'><b>Login failed</b></font>");
		}
	}
	public void  addUserList()
	{
		String str = driver.findElement(By.id("menu_dashboard_index")).getText();
		if(str.contains("Dashboard"))
		{
			exttest.log(Status.PASS,"User added to the list");
		}
		else
		{
			exttest.log(Status.FAIL,"User not added to the list");	
		}
	}
}



