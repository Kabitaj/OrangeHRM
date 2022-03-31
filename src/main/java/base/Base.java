package base;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base
{	
	public static Properties prop;       
	public static WebDriver driver;
	public static String userName;
	public static ExtentHtmlReporter exthtml;
	public static ExtentTest exttest;
	public static ExtentReports report;


	@BeforeSuite
	public void setup() throws Exception 
	{
		prop=new Properties();
		prop.load(new FileInputStream("src/main/java/Config/Config.properties"));
		exthtml = new ExtentHtmlReporter(prop.getProperty("reports"));
		report = new ExtentReports();
		report.attachReporter(exthtml);
		report.setSystemInfo("Host Name","TestSystem"); //name of the system
		report.setSystemInfo("Environment","Test Env");
		report.setSystemInfo("User Name","Kabita");
		exthtml.config().setDocumentTitle("OrangeHRM");
		exthtml.config().setReportName("OrangeHRM Functional Testing");
		exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
		exthtml.config().setTheme(Theme.STANDARD);
	}


	@BeforeTest
	@Parameters({"browser"})
	public void initialize(String browser)
	{
		if(browser.matches("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			userName="KabitaJaisi";
		}
		if(browser.matches("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			userName="KabitaJai";
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
		report.flush();

	}
}
