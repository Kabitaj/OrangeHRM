package orangeTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import orange.HrmFunction;

public class OrangeStepDef 
{ 
	HrmFunction hf=new HrmFunction();
	
	@Given("^User is on OrangeHRM website(.+)$")
	public void user_is_on_orangehrm_website(String browser) throws Throwable 
	{
		hf.initialize(browser);
		hf.setup();
		hf.openURL();
	}

	@When("^Valid Login id and password are entered$")
	public void valid_login_id_and_password_are_entered() throws Throwable
	{
		hf.login();
	}

	@Then("^Login is Successful$")
	public void login_is_successful() throws Throwable
	{
		System.out.println("The user Loggedin successfully");
	}
	@Given("^User is on Admin/User management page$")
    public void user_is_on_adminuser_management_page() throws Throwable
	{
       hf.createUser(); 
    }

    @When("^All the mandatory fields are filled$")
    public void all_the_mandatory_fields_are_filled() throws Throwable 
    {
       hf.addUser();
    }

    @Then("^User is created$")
    public void user_is_created() throws Throwable 
    {
        hf.displayAddedUser();
    }
    

    @When("^User is selected and clicked delete$")
    public void user_is_selected_and_clicked_delete() throws Throwable 
    {
       hf.deleteUser();
    }

    @Then("^User is deleted$")
    public void user_is_deleted() throws Throwable
    {
        hf.displayList();
        hf.logOut();
        hf.tearDown();
       
    }


}
