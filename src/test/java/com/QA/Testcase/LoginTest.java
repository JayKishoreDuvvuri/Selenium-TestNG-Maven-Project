package com.QA.Testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.QA.Library.Utility;

public class LoginTest extends Utility {

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void setUp(String browser, String url) {
         initialisation(browser, url);
	}

	@Parameters({ "expectedTitle", "expectedUrl" })
	@Test
	public void loginTest(String expectedTitle, String expectedUrl) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("pedroalmodovar@test.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("1q2w3e");
		driver.findElement(By.name("Submit")).click();
		String actualTitle = driver.getTitle();
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertEquals(actualUrl, expectedUrl);
		takeScreenshot();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
