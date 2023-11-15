package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		
		features="C:\\Users\\Vanak\\eclipse-workspace\\ATE-Capstone-Cucumberproject\\src\\test\\java\\Feature\\sporty.feature",
		glue = {"test"},
				dryRun=false,
		plugin = { "html:target/sportyshoes.html",
				"pretty"  ,
				
				
				"timeline:test-output-thread/"	
				
						})
		
		
		
		
public class RunnerCucumber {

}
