package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibraries.CommonActions;

public class Pf_HomePage extends CommonActions{
	
	@FindBy(linkText="Sign In")
	public WebElement lk_signIn;
	
	@FindBy(id="username")
	public WebElement lbl_userName;
	
	@FindBy(id="srchword")
	public WebElement txt_search;
	
	@FindBy(className="newsrchbtn")
	public WebElement btn_search;
		
	@FindBy(className="sorrymsg")
	public WebElement lbl_searcherrormsg;
	
	@FindBy(id="find")
	public WebElement lbl_searchcount;
	
	@FindBy(xpath="//div[@id='myDataDiv']/div/div[@class='bookbox'][1]//img")
	public WebElement img_firstbook;
	
	public Pf_HomePage(WebDriver driver){		
		PageFactory.initElements(driver, this);		
	}
	
//	
	public void enterSearch(String val){
		caEnterValue(txt_search, val);
		caClick(btn_search);
		
	}
	
	
	

}
