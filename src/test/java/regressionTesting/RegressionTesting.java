package regressionTesting;


import org.testng.annotations.Test;

import orange.HrmFunction;

public class RegressionTesting 
{
	@Test
	public void regTest() throws Exception
	{
		HrmFunction exec=new HrmFunction();
		exec.login();
		exec.createUser();
		exec.addUser();
		exec.displayAddedUser();
		exec.deleteUser();
		exec.displayList();
		exec.logOut();
		exec.tearDown();

	
	}

}
