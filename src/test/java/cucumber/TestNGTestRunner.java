package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="vaveTuts.stepDefination",monochrome=true,plugin={"html:target/cucumber.html"}
, tags = "@Regression or @ErrorValidation")
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	

}
