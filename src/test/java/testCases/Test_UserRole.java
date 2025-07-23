package testCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import commonFunctions.CommonsFunctions;
import pageObjects.Dashboard_Page_Object_Model;
import pageObjects.Login_Page_Object_Model;
import pageObjects.UserRole_Page_Object_Model;

public class Test_UserRole extends CommonsFunctions{
	
	UserRole_Page_Object_Model userRole;
	
	static Logger logger=Logger.getLogger(Test_UserRole.class);
	@Test
	public void adminActions() {
		
		userRole = PageFactory.initElements(driver, UserRole_Page_Object_Model.class);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		 logger.info("Clicking the Admin Tab");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.admin)).click();
		 
		 logger.info("Clicking the userManagement");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.userManagement)).click();
		 logger.info("Clicking the user");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.user)).click();
		 logger.info("Clicking the userRole");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.userRole)).click();
		 logger.info("Clicking the selectAdmin");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.selectAdmin)).click();
		 logger.info("Clicking the select");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.select)).click();
		 logger.info("Clicking the enabled");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.enabled)).click();
		 logger.info("Clicking the search");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.search)).click();
		 String employeeNames=userRole.employeeName.getText();
		 System.out.println(employeeNames);
		
	}
}
