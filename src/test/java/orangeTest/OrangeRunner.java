package orangeTest;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
	(
		features= {"src/test/java/orangeTest/OHRM.feature"}
		,glue= {"orangeTest"}
		,tags="@OrangeHRM"
	)


public class OrangeRunner
	{

	}
