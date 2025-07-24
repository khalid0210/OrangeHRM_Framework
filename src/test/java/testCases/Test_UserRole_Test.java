package testCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import commonFunctions.CommonsFunctions;
import pageObjects.Dashboard_Page_Object_Model;
import pageObjects.Login_Page_Object_Model;
import pageObjects.UserRole_Page_Object_Model;

public class Test_UserRole_Test extends CommonsFunctions{
	
	UserRole_Page_Object_Model userRole;
	
	static Logger logger=Logger.getLogger(Test_UserRole_Test.class);
	@Test
	public void adminActions() {
		testCase=extentReport.createTest("verifying the admin Actions");
		userRole = PageFactory.initElements(driver, UserRole_Page_Object_Model.class);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		 testCase.log(Status.INFO,"Clicking the Admin Tab");
		 logger.info("Clicking the Admin Tab");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.admin)).click();
		 
		 testCase.log(Status.INFO,"Clicking the userManagement");
		 logger.info("Clicking the userManagement");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.userManagement)).click();
		 
		 testCase.log(Status.INFO,"Clicking the user");
		 logger.info("Clicking the user");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.user)).click();
		 
		 testCase.log(Status.INFO,"Clicking the userRole");
		 logger.info("Clicking the userRole");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.userRole)).click();
		 
		 testCase.log(Status.INFO,"Clicking the selectAdmin");
		 logger.info("Clicking the selectAdmin");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.selectAdmin)).click();
		 
		 testCase.log(Status.INFO,"Clicking the select");
		 logger.info("Clicking the select");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.select)).click();
		 
		 testCase.log(Status.INFO,"Clicking the enabled");
		 logger.info("Clicking the enabled");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.enabled)).click();
		 
		 testCase.log(Status.INFO,"Clicking the search");
		 logger.info("Clicking the search");
		 wait.until(ExpectedConditions.elementToBeClickable(userRole.search)).click();
		 String employeeNames=userRole.employeeName.getText();
		 System.out.println(employeeNames);
		
	}
}
