package orange;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import base.Base;
import objects.Elements;
import reusable.Interactions;
import reusable.Reusable;


public class HrmFunction extends Base 
{ 

	 Reusable ss=new Reusable();
	/*creating methods
	 * openURl
	 * Login
	 * createUser
	 * addUser
	 */

	public void openURL() throws Exception 
	{	
		exttest=report.createTest("Validate_Url");//Validating if URL is working	
		driver.get(prop.getProperty("url"));  //For Opening the url in browsers
		//exttest.log(Status.FAIL,"Login failed");
		exttest.log(Status.PASS, "Webpage is working");
		ss.screenshot("webpage.jpg");
	}

	public void login() throws Exception
	{
		Interactions.writText(driver.findElement(Elements.user),"Admin");      // Enter User name
		Interactions.writText(driver.findElement(Elements.pass), "admin123");   // Enter password
		Interactions.clickButton(driver.findElement(Elements.login));               // Click on Login button

		ss.screenshot("Login.jpg");


	}
	public void createUser() throws Exception 
	{
		 
		Interactions.clickButton(driver.findElement(Elements.pim));//Click on Pim in the website
		Interactions.clickButton(driver.findElement(By.linkText("Add Employee")));	//Add employee link
		Interactions.writText(driver.findElement(By.id("firstName")),"Kabita");	//Enter Firstname
		Interactions.writText(driver.findElement(By.id("lastName")),"Jaiswal");  //Enter lastname
		Interactions.clickButton(driver.findElement(Elements.save));					//Click save button
		exttest=report.createTest("Validate_Loginpage");
		ss.validate();
		ss.screenshot("Createuserpage.jpg");
	}

	public void addUser() throws Exception
	{
	 
		Interactions.clickButton(driver.findElement(By.id("menu_admin_viewAdminModule")));
		Interactions.clickButton(driver.findElement(By.id("btnAdd")));
		Interactions.selectFromList(driver.findElement(By.id("systemUser_userType")), "ESS");
		Interactions.writText(driver.findElement(By.id("systemUser_employeeName_empName")), "kabita jaiswal");
		Interactions.writText(driver.findElement(By.name("systemUser[userName]")), userName);		
		Interactions.selectFromList(driver.findElement(By.id("systemUser_status")), "Enabled");		
		Interactions.writText(driver.findElement(By.id("systemUser_password")), "kabita@123");
		Interactions.writText(driver.findElement(By.id("systemUser_confirmPassword")), "kabita@123");
		Thread.sleep(1000);
		Interactions.clickButton(driver.findElement(By.id("btnSave")));
		exttest=report.createTest("Validate Add user page");
		ss.addUserList();
		ss.screenshot("Afteraddinguserpage.jpg");

	}

	public void displayAddedUser() throws Exception
	{	

		List<WebElement> li1=driver.findElements(Elements.userList);
		exttest=report.createTest("After adding user list");
		for(WebElement e1:li1)
		{
			System.out.println(e1.getText());
			exttest.log(Status.INFO, e1.getText());
		}
		FileInputStream fin=new FileInputStream("C:\\Excel_prac\\Book1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Row row;
		for(int i=0; i<li1.size(); i++)
		{
			row=ws.createRow(i);
			row.createCell(0).setCellValue(li1.get(i).getText());
		}
		FileOutputStream fos=new FileOutputStream("C:\\Excel_prac\\Book1.xlsx");
		wb.write(fos);
		ss.screenshot("Displayig added userPage.jpg");



	}
	public void deleteUser() throws Exception 
	{

		Interactions.clickButton(driver.findElement(By.id("menu_admin_viewAdminModule")));
		Interactions.writText(driver.findElement(Elements.search),userName); 
		Interactions.clickButton(driver.findElement(Elements.clk_Search));
		Interactions.clickButton(driver.findElement(Elements.checkBox));
		Interactions.clickButton(driver.findElement(Elements.delete));
		Interactions.clickButton(driver.findElement(By.id("dialogDeleteBtn")));
		Thread.sleep(2000);
		Interactions.writText(driver.findElement(Elements.search), userName);
		Interactions.clickButton(driver.findElement(Elements.clk_Search)); 
		ss.screenshot("Deleting user page.jpg");


	}

	public void displayList() throws Exception
	{	
		List<WebElement> li2=driver.findElements(Elements.userList);
		exttest=report.createTest("After deleting  user list");
		for(WebElement e:li2)
		{
			System.out.println(e.getText());
			exttest.log(Status.INFO, e.getText());

		}
		ss.screenshot("DisplayList.jpg");
	}
	public void logOut() throws Exception
	{
		Interactions.clickButton(driver.findElement(Elements.Log));
		ss.screenshot("Logout.jpg");
		Interactions.clickButton(driver.findElement(Elements.Logout));

	}

}

