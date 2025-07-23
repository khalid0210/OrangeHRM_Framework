package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRole_Page_Object_Model {
	
	@FindBy(xpath="(//ul[@class='oxd-main-menu']//following::li)[1]")
	public static WebElement admin;
	
	@FindBy(xpath="(//div[@class='oxd-topbar-body']//nav/ul/li)[1]")
	public static WebElement userManagement;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']")
	public static WebElement user;
	
	@FindBy(xpath="(//div[@class='oxd-select-wrapper'])[1]")
	public static WebElement userRole;
	
	@FindBy(xpath="//div[@role='listbox']//div[normalize-space()='Admin']")
	public static WebElement selectAdmin;
	
    @FindBy(xpath="(//div[@class='oxd-select-wrapper'])[2]")
    public static WebElement select;
    
    @FindBy(xpath="//div[@role='listbox']//div[normalize-space()='Enabled']")
    public static WebElement enabled;
    
    @FindBy(xpath="//button[text()=' Search ']")
    public static WebElement search; 
    
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[4]/div")
    public static WebElement employeeName;
}
