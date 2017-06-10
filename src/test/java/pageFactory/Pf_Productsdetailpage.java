package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibraries.CommonActions;

public class Pf_Productsdetailpage extends CommonActions {
	
	
	@FindBy(className="buynowbtnbig")
	public WebElement btn_buynow;
	
	public Pf_Productsdetailpage(WebDriver driver){
		PageFactory.initElements(driver, this);		
	}
	
	
	
	
	
	
	

}
