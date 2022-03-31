package reusable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Interactions 
{
  public static void writText(WebElement ele, String inputstr)
  {
	  try
	  {
		  if(ele.isDisplayed() && ele.isEnabled())
		  {
			  ele.sendKeys(inputstr);
		  }
	  }
	  catch(Exception e)
	  {
		  System.out.println(ele.getTagName()+" is not available");
	  }
  }
  public static void selectFromList(WebElement ele,String inputvalue)
  {
	  Select select=new Select(ele);
	  select.selectByVisibleText(inputvalue);
  }
  public static void clickButton(WebElement ele)
  {
	  
		  if(ele.isDisplayed() && ele.isEnabled())
		  {
			  ele.click();
		  }
	  
  }
  
}
