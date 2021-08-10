package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By login = By.xpath("//a[text()='Login']");
	By naviagtioBar=By.xpath("//a[text()='Demo']");
	public LandingPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public WebElement clickOnLogin() {

		return driver.findElement(login);
	}
		
	public WebElement navigationBar() {
		return driver.findElement(naviagtioBar);
	}
	
	
}
