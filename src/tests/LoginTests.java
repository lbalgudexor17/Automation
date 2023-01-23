package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import myCo.BaseClass;
import myCo.TestDataCo;
import pages.LoginMyCo;



public class LoginTests {
 LoginMyCo lgn;
	
	 @BeforeMethod
	    void setup(){
	        BaseClass.initialization();
	    }
	 
	 @Test(priority = 2)
	 void checklogotest() {
		 lgn =new LoginMyCo();
		 lgn.checkLogo();
		 Assert.assertEquals(lgn.checkLogo(), true);
		 System.out.println("Logo Displayed");
	 }

	    @Test (priority = 1)
	    void login(){
	    	lgn = new LoginMyCo();
	    	lgn.login();
	    	//Assert.assertEquals(TestDataCo.pageURL, lgn.actualURL);
	    	System.out.println("Logged In");
	    }
	        
	       
	    @AfterMethod
	    void teardown(){
	    	BaseClass.quit();
	    }
}
