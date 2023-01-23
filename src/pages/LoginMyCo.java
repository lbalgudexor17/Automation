package pages;

import org.openqa.selenium.WebElement;

import myCo.BaseClass;
import myCo.TestDataCo;

public class LoginMyCo extends BaseClass {
	public String actualURL;
	
	public boolean checkLogo() {
		WebElement logo = BaseClass.getElement(TestDataCo.logo);
		return BaseClass.getLogo(logo);
	}
	
    public void login() {
    	WebElement user=BaseClass.getElement(TestDataCo.id);
    	BaseClass.sendText(user,TestDataCo.username);
    	WebElement pass = BaseClass.getElement(TestDataCo.password);
    	BaseClass.sendText(pass,TestDataCo.pasword);
    	WebElement btn = BaseClass.getElement(TestDataCo.signInButton);
    	BaseClass.clickOnElement(btn);
    	 actualURL = BaseClass.getURL();
    	 System.out.println(actualURL);
    }

}
