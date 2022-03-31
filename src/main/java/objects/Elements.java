package objects;

import org.openqa.selenium.By;

public class Elements {
	public static By user=By.id("txtUsername");
	public static By pass=By.id("txtPassword");
	public static By login=By.id("btnLogin");
	public static By pim=By.id("menu_pim_viewPimModule");
	public static By userList=By.cssSelector("table#resultTable>tbody>tr");

	public static By search=By.name("searchSystemUser[userName]");
	public static By clk_Search=By.cssSelector("input.searchbutton");
	public static By save=By.cssSelector("input[value='Save']");
	public static By checkBox=By.cssSelector("#ohrmList_chkSelectAll");
	public static By delete=By.cssSelector("input.delete");
	public static By Log=By.cssSelector("#welcome");
	public static By Logout=By.linkText("Logout");
}
