package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibraries.CommonActions;

public class Pf_Cartpage extends CommonActions{

	@FindBy(xpath="//cite[@class='mid']/span[2]")
	public WebElement lbl_book;
	
	@FindBy(id="frmCart")
	public WebElement frm_cart;
	
	public Pf_Cartpage(WebDriver driver){		
		PageFactory.initElements(driver, this);		
	}
	
	
}
