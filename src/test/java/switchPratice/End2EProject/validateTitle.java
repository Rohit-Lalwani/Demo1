package switchPratice.End2EProject;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class validateTitle extends base {
	private static Logger Log = LogManager.getLogger(base.class.getName());

	@Test
	public void validateTitleOfNavigationBar() throws Exception {

		driver = intializeDriver();
		driver.get("https://phptravels.com/demo/");
		Log.info("Driver is inlizatilise");
		// CLicking on Login button
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.navigationBar().getText(),"Demoo");
		System.out.println("validateTitleOfNavigationBar khatam");
	}
}
