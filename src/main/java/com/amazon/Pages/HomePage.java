package com.amazon.Pages;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	public WebDriver driver;

	@FindBy(id = "searchDropdownBox")
	private WebElement selectCat;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement enterSearchItem;

	@FindBy(xpath = "//div[@data-index='1']//a[@class='a-link-normal a-text-normal']")
	private WebElement selectSearchresultitem;

	@FindBy(id = "add-to-wishlist-button-submit")
	private WebElement addToWishListBtn;

	@FindBy(partialLinkText = "Read more..")
	private WebElement readMoreText;

	@FindBy(xpath = "//span[@class='a-button a-button-base askSeeMoreQuestionsLink']/span")
	private WebElement showMoreAnswer;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver; // initializing instance variable with local variable
		PageFactory.initElements(driver, this); // this elements method will create all WebElements
	}

	public void selectCategories(String cat) {
		Select selectCatDDL = new Select(selectCat);
		selectCatDDL.selectByVisibleText(cat);

	}

	public void enterItem(String item) {
		enterSearchItem.sendKeys(item + Keys.ENTER);
	}

	public void selectSearchResulItem() {
		selectSearchresultitem.click();
	}

	public void switchWindowTab() {
		String window = driver.getWindowHandle();

		Set<String> allNewTabs = driver.getWindowHandles();

		int number_tabs = allNewTabs.size();

		int new_tab_index = number_tabs - 1;

		driver.switchTo().window(allNewTabs.toArray()[new_tab_index].toString());

		String searchResultTabTitle = driver.getTitle();

		System.out.println("New Window page Title is : "+searchResultTabTitle);
		//assertEquals(searchResultTabTitle,
				//"Buy Apple MacBook Air (13-inch, 8GB RAM, 128GB Storage, 1.8GHz Intel Core i5) - Silver Online at Low Prices in India - Amazon.in");
		readMoreText.click();
		
		showMoreAnswer.click();
		
	}

	public void AddToWishList() {

	
		//addToWishListBtn.click();
	}

}
