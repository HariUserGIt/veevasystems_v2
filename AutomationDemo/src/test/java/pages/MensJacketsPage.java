package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class MensJacketsPage {
 WebDriver driver;
 
 private By list_Jackets = By.xpath("//span[.='Most Popular in Jackets']/parent::div/../..");
 private By nextPageBtn = By.xpath("//a[@title='Next']");

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

 public List<String> getAllJacketsData() {
     List<String> jacketsData = new ArrayList<>();

     boolean hasNextPage = true;
     while (hasNextPage) {
         List<WebElement> jackets = driver.findElements(list_Jackets);

         for (WebElement jacket : jackets) {
             String title = jacket.findElement(By.xpath(".//h3")).getText();
             String price = jacket.findElement(By.xpath(".//span[contains(@class,'price')]")).getText();
             String topSeller = "";
             try {
                 topSeller = jacket.findElement(By.xpath(".//span[contains(text(),'Top Seller')]")).getText();
             } catch (Exception e) {
                 topSeller = "No Top Seller Tag";
             }

             jacketsData.add("Title: " + title + " | Price: " + price + " | Tag: " + topSeller);
         }

         // Check for pagination
         try {
             WebElement nextBtn = driver.findElement(nextPageBtn);
             if (nextBtn.isDisplayed()) {
                 nextBtn.click();
             } else {
                 hasNextPage = false;
             }
         } catch (Exception e) {
             hasNextPage = false;
         }
     }

     return jacketsData;
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

