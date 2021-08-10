package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email = By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@type='password']");
	/*By captchaCheckBox =By.xpath("//span[@role='checkbox']/div[2]");*/
	By LoginButton=	By.xpath("//input[@id='login']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	/*
	 * public WebElement captchaCheckBox() { return
	 * driver.findElement(captchaCheckBox); }
	 */
	
	public WebElement loginButton() {
		return driver.findElement(LoginButton);
	}
	
}
