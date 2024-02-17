package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="Rahulshettyacademy.Stepdefinitions",
monochrome = true,plugin= {"html:target/cucumber.html"})
public class TestngtestRunner extends AbstractTestNGCucumberTests {

}
/* here to run the cucumber test cucumber don't know how to run testNG for that we have to develop 
 for that we have develop AbstractTestNGCucumberTests method and features location of cucumber file glue mention the step definitions
 the result is in encoded format for that we use monochrome for readable format 
 plain static text 
 cucumber cannot run on its own it will give you framework features all
 it would be depends upon either testNG or junit based on what kind of code you have
 it cannot follow all testNG framework features cucumber haves his own features it use it for just runner  */