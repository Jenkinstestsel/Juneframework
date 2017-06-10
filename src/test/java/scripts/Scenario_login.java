package scripts;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageFactory.Pf_HomePage;
import pageFactory.Pf_LoginPage;
import commonLibraries.Base;

public class Scenario_login extends Base{
	
//	valid Login script
	@Test(dataProvider="Dpglobal",dataProviderClass=dataProvider.Dp_RediffProj.class,groups={"uat"})
	public void Login_validLogin(Map<String,String> hm) throws Exception{		
		Log = Logger.getLogger(Scenario_login.class);
		
		startTest = eReports.startTest(hm.get("TC_ID") + "_" + hm.get("Order"));
		
		startTest.log(LogStatus.INFO, "Start Execution", "Started execution of testcase");
//		click on sig in link
//		ff.findElement(By.linkText("Sign In")).click();
		Pf_HomePage homePage = new Pf_HomePage(ff);
		homePage.caClick(homePage.lk_signIn);		
		
		Log.info("Started Execution");
	
		
//		Enter the login details
//		ff.findElement(By.name("logid")).sendKeys("qtpworld2008@gmail.com");
//		ff.findElement(By.name("pswd")).sendKeys("learn123");
//		ff.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
		Pf_LoginPage loginPage = new Pf_LoginPage(ff);
		Log.info("Entering login details");
		loginPage.enterLoginDetails(hm.get("Username"), hm.get("Password"));
		
		
		String exp=hm.get("Expectedmsg");
//		validation
		
//		String act= ff.findElement(By.className("username")).getText();
		String act= homePage.caGetOuptut(homePage.lbl_userName);
		if(act.equals(exp)){
			Log.info("Actual and expected matching");
			startTest.log(LogStatus.PASS, "Valid login validation","Passed as user successfully logged in");
			System.out.println("pass");
		}else{
			startTest.log(LogStatus.FAIL, "Valid login validation","Failed as actual " + act + " and expected was " + exp + "." + startTest.addScreenCapture(getscreen()));
			Log.info("Actula is " + act + " and expected is " + exp);
			System.out.println("fail");
		}
		
			
	}
	
	
//	Invalid Login
	@Test(dataProvider="Dpglobal",dataProviderClass=dataProvider.Dp_RediffProj.class,groups={"prod"})
	public void invalidLogin(Map<String,String> hm) throws Exception{		
		Log = Logger.getLogger(Scenario_login.class);
		startTest = eReports.startTest(hm.get("TC_ID") + "_" + hm.get("Order"));
//		click on sig in link
		Pf_HomePage homePage = new Pf_HomePage(ff);
		homePage.caClick(homePage.lk_signIn);	
		
//		Enter the login details
		Pf_LoginPage loginPage = new Pf_LoginPage(ff);
		loginPage.enterLoginDetails(hm.get("Username"), hm.get("Password"));
		
		
		String exp=hm.get("Expectedmsg");
//		validation
		
		String act= loginPage.caGetOuptut(loginPage.lbl_loginErrorMsg);
		
		if(act.equals(exp)){	
			startTest.log(LogStatus.PASS, "InValid login validation","Passed InValid login validation ");
			System.out.println("pass");			
		}else{
			startTest.log(LogStatus.PASS, "InValid login validation","Failed as actual " + act + " and expected was " + exp + "." + startTest.addScreenCapture(getscreen()));
			System.out.println("fail");
		}
		
		
		
	}
	
	

}
