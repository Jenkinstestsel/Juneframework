package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibraries.CommonActions;

public class Pf_LoginPage extends CommonActions{
	
	
	@FindBy(name="logid")
	public WebElement txt_username;
	
	@FindBy(name="pswd")
	public WebElement txt_password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	public WebElement btn_login;
	
	@FindBy(xpath="//b[contains(text(),'Sorry we')]")
	public WebElement lbl_loginErrorMsg;
	
	public Pf_LoginPage(WebDriver driver){		
		PageFactory.initElements(driver, this);		
	}
	
	
//	common logic
	public void enterLoginDetails(String uname,String pwd){
		caEnterValue(txt_username,uname);
		caEnterValue(txt_password,pwd);
		caClick(btn_login);
				
//		txt_username.sendKeys(uname);
//		txt_password.sendKeys(pwd);
//		btn_login.click();		
//		
	}
	
	
	
	
	
	

}
