package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import commonFunctions.CommonsFunctions;
import pageObjects.Dashboard_Page_Object_Model;
import pageObjects.Login_Page_Object_Model;

public class Test_Pending_Leave_Request_Test extends CommonsFunctions{
	Login_Page_Object_Model login;
	Dashboard_Page_Object_Model dashboard ;
	String message;

	static Logger logger=Logger.getLogger(Test_Pending_Leave_Request_Test.class);
	
	public void login() {
		logger.info("Logging into the application");
		login=PageFactory.initElements(driver,Login_Page_Object_Model.class);
		login.userName.sendKeys(properties.getProperty("username"));
		login.passWord.sendKeys(properties.getProperty("password"));
		login.submitButton.click();
	}
	
	public void applyleave() {
		dashboard = PageFactory.initElements(driver, Dashboard_Page_Object_Model.class);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.applyLeave));
		dashboard.applyLeave.click();
	}
	
	public void leaveText() {
		message=dashboard.leaveType.getText();
	}
	@Test
	public void verifyPendingLeaveRequest() throws IOException {
		
		login();
		testCase=extentReport.createTest("verify Pending Leave Request");
		testCase.log(Status.INFO,"Clicking the apply leave option");
		logger.info("Clicking the apply leave option");
		applyleave();
		testCase.log(Status.INFO,"Getting the Leave Text");
		logger.info("Getting the Leave Text");
		leaveText();
		System.out.println(message);
		testCase.log(Status.INFO,"Getting the Leave Text" +message);
		logger.info("Verifying the message");
		Assert.assertEquals(message, "No Leave Types with Leave Balance");
		
		
		 
	}

}
