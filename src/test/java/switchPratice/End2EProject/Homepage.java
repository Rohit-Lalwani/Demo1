package switchPratice.End2EProject;

import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class Homepage extends base {

	@Test(dataProvider ="getData")
	public void basePageNavigation(String username,String password) throws Exception {

		driver = intializeDriver();
		driver.get("https://phptravels.com/demo/");

		// CLicking on Login button
		LandingPage lp = new LandingPage(driver);
		String currentWindow = driver.getWindowHandle();
		String Urltoclcik = lp.clickOnLogin().getAttribute("href");

		lp.clickOnLogin().click();
		// Get All the handles
		Set<String> handles = driver.getWindowHandles();

		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentWindow)) {
				driver.switchTo().window(actual);
			}
		}
		LoginPage lop = new LoginPage(driver);
		lop.getEmail().sendKeys(username);
		lop.getPassword().sendKeys(password);
		/* lop.captchaCheckBox().click(); */
		lop.loginButton().click();
		System.out.println("EOP");

	}
	
	@DataProvider
	 public Object[][] getData(){
		//Row Stands for 
		Object[][] data =new Object[2][2];
		//0th row
		data[0][0]="data0@gmail.com";
		data[0][1]="1stpassword";
		
		//1st row
		data[1][0]="farzidata@gmail.com";
		data[1][1]="2ndpassword";
		return data;
		
		
	}
}
