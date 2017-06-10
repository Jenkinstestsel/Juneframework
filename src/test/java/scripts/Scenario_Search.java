package scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageFactory.Pf_HomePage;

import com.relevantcodes.extentreports.LogStatus;

import commonLibraries.Base;

public class Scenario_Search extends Base{
	
	
//	valid searche
	@Test(dataProvider="Dpglobal",dataProviderClass=dataProvider.Dp_RediffProj.class,priority=1,groups={"uat","qa","prod"})
	public void validsearch(Map<String,String> hm) throws Exception{
		
		Log = Logger.getLogger(Scenario_Search.class);		
		startTest = eReports.startTest(hm.get("TC_ID") + "_" + hm.get("Order"));
		startTest.assignCategory(browser_type);
		System.out.println("hi");

		System.out.println("hi1");


		System.out.println("hi5");

		System.out.println("hi7");

//		if(ff.getTitle().toLowerCase().contains("rediff")){
//			Log.info("Home page title successfully validated");
//			startTest.log(LogStatus.PASS, "Home page Title","Passed theHome page Title ");
//			
//		}else{
//			Log.error("Failed Home Page title Validation as Actual " + ff.getTitle().toLowerCase() + " and expected is rediff");
//			startTest.log(LogStatus.FAIL, "Home page Title","Failed Home Page title Validation as Actual " + ff.getTitle().toLowerCase() + " and expected is rediff");
//		}
		
		cvContains(ff.getTitle().toLowerCase(), "online bookstore", "Home page Title");
		
		Pf_HomePage homepage = new Pf_HomePage(ff);
		homepage.enterSearch(hm.get("searchoptions"));
//		Validation of application search count against the one provided by the user from the excel sheet
//		if(homepage.caGetOuptut(homepage.lbl_searchcount).equals(hm.get("expected"))){
//			Log.info("Search vcount validated");
//			startTest.log(LogStatus.PASS, "Search count validated","Passed Search count validation");
//			
//		}else{
//			Log.error("Failed Search count validated as Actual " + homepage.caGetOuptut(homepage.lbl_searchcount) + " and expected is " + hm.get("expected"));
//			startTest.log(LogStatus.FAIL, "Search count validated","Failed Search count validated as Actual " + homepage.caGetOuptut(homepage.lbl_searchcount) + " and expected is " + hm.get("expected") + startTest.addScreenCapture(getscreen()));
//		}	
		cvEquals(homepage.caGetOuptut(homepage.lbl_searchcount), hm.get("expected"), "Search count validation", homepage.lbl_searchcount);

		
	}
	
	
	
//	invalid search
	
//	valid searche
	@Test(dataProvider="Dpglobal",dataProviderClass=dataProvider.Dp_RediffProj.class,priority=2,groups={"prod"})
	public void invalidsearch(Map<String,String> hm) throws Exception{

		Log = Logger.getLogger(Scenario_Search.class);		
		startTest = eReports.startTest(hm.get("TC_ID") + "_" + hm.get("Order"));
		startTest.assignCategory(browser_type);
		System.out.println("hello");
//		if(ff.getTitle().toLowerCase().contains("rediff")){
//			Log.info("Home page title successfully validated");
//			startTest.log(LogStatus.PASS, "Home page Title","Passed theHome page Title ");
//			
//		}else{
//			Log.error("Failed Home Page title Validation as Actual " + ff.getTitle().toLowerCase() + " and expected is rediff");
//			startTest.log(LogStatus.FAIL, "Home page Title","Failed Home Page title Validation as Actual " + ff.getTitle().toLowerCase() + " and expected is rediff");
//		}
		
		cvContains(ff.getTitle().toLowerCase(), "online bookstore", "Home page Title");
		
		Pf_HomePage homepage = new Pf_HomePage(ff);
		homepage.enterSearch(hm.get("searchoptions"));
//		Validation of application search count against the one provided by the user from the excel sheet
//		if(homepage.caGetOuptut(homepage.lbl_searcherrormsg).equals(hm.get("expected"))){
//			Log.info("Invalid Search  validated");
//			startTest.log(LogStatus.PASS, "Invalid Search  validated","Passed Search count validation");
//			
//		}else{
//			Log.error("Failed Search msg validated as Actual " + homepage.caGetOuptut(homepage.lbl_searcherrormsg) + " and expected is " + hm.get("expected"));
//			startTest.log(LogStatus.FAIL, "Invalid Search  validated","Failed Search msg validated as Actual " + homepage.caGetOuptut(homepage.lbl_searcherrormsg) + " and expected is " + hm.get("expected") + startTest.addScreenCapture(getscreen()));
//		}	
		
		cvEquals(homepage.caGetOuptut(homepage.lbl_searcherrormsg), hm.get("expected"), "Invalid Search  validation", homepage.lbl_searcherrormsg);

	}
	
	
	
	
	

}
