package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Object_Model {
	@FindBy(name = "username")
	public static WebElement userName;

	@FindBy(name = "password")
	public static WebElement passWord;

	@FindBy(xpath = "//button[text()=' Login ']")
	public static WebElement submitButton;
}
