package com.amazon.TestCases;

import org.testng.annotations.Test;

import com.amazon.Pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class HomePageTest {

	static WebDriver driver;
	static HomePage homepageObject;

	@BeforeTest
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium World\\Library\\ChromeDriver_v80\\chromedriver_v80.exe");
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void TC_Scenarios_01() {

		homepageObject = new HomePage(driver);
		System.out.println("TC_01_ToVerifyUserableToSelectCategory");
		homepageObject.selectCategories("Electronics");

		System.out.println("TC_02_ToVerifyUserableToSearchItem");
		homepageObject.enterItem("Apple Laptop");

		System.out.println("TC_03_ToVerifyUserableToSelectSearchResult");
		homepageObject.selectSearchResulItem();
	}

	@Test
	public void TC_Scenarios_02() {

		homepageObject.switchWindowTab();
		System.out.println("Verify user able to switch on new tab successfully....");
		
	}

	@AfterTest
	public void afterMethod() {
		// driver.quit();
	}

}
