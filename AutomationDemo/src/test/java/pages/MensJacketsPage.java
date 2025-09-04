package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class MensJacketsPage {
 WebDriver driver;

 @FindBy(xpath = "//div[@class='product-card-title']")
 List<WebElement> jacketTitles;

 @FindBy(xpath = "//div[contains(@class,'price primary')]")
 List<WebElement> jacketPrices;

 @FindBy(xpath = "//div[@class='product-vibrancy-container']")
 List<WebElement> sellerMessages;

 @FindBy(xpath = "//a[contains(@class,'next-page')]")
 WebElement nextPageButton;

 public MensJacketsPage(WebDriver driver) 
	 {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }

 public List<String> getAllJacketData() 
 {
	 List<String> jacketData = new ArrayList<>();
	
	 do {
	 for (int i = 0; i < jacketTitles.size(); i++) {
	 String title = jacketTitles.get(i).getText();
	 String price = (i < jacketPrices.size()) ? jacketPrices.get(i).getText() : "N/A";
	 String sellerMsg = (i < sellerMessages.size()) ? sellerMessages.get(i).getText() : "N/A";
	
	 jacketData.add("Title: " + title + " | Price: " + price + " | Seller Message: " + sellerMsg);
	 }
	 } while (goToNextPage());
	
	 return jacketData;
 }

 private boolean goToNextPage() 
	 {
	 try {
	 if (nextPageButton.isDisplayed()) {
	 nextPageButton.click();
	 Thread.sleep(2000); // Wait for page load
	 PageFactory.initElements(driver, this); // Refresh elements
	 return true;
	 }
	 } catch (Exception e) {
	 return false;
	 }
	 return false;
 }
}

