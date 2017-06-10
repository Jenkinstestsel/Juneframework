package commonLibraries;

import org.openqa.selenium.WebElement;

public class CommonActions {
	
//	enter value
	public void caEnterValue(WebElement ele,String val){
		ele.sendKeys(val);		
	}
	
//	Click on any element
	public void caClick(WebElement ele){
		ele.click();
	}
	
//	get Text of an element
	public String caGetOuptut(WebElement ele){
		return ele.getText();
	}

}
