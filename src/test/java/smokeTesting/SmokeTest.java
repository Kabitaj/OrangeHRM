package smokeTesting;


import org.testng.annotations.Test;

import orange.HrmFunction;

public class SmokeTest 
	
	{
		@Test
		public void smokeTest() throws Exception
		{
			HrmFunction exec=new HrmFunction();
			exec.setup();
			exec.initialize("browser");
			exec.openURL();
			
		}
	
	}
