package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;
import java.util.NoSuchElementException;

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

 public List<String> getMostPopularJackets(WebDriver driver) {
	    List<String> jacketItems = new ArrayList<>();
	    
	    WebElement item1 = driver.findElement(By.xpath("//span[.='Most Popular in Jackets']"));

	    Actions actions = new Actions(driver);
	    actions.moveToElement(item1).perform();

	    List<WebElement> items_size = driver.findElements(By.xpath("//span[.='Most Popular in Jackets']"));
	    

	 // Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item1);

	    int size = items_size.size();
	    
	    if(size>0)
	    {
	    
		    // Find all child elements (e.g., product titles or descriptions)
		    List<WebElement> items = driver.findElements(By.xpath("//span[.='Most Popular in Jackets']")); // Adjust this if you know the exact tag
	
		    // Extract and collect non-empty text
		    for (WebElement item : items) {
		        String text = item.getText().trim();
		        if (!text.isEmpty()) {
		            jacketItems.add(text);
		        }
		    }
	    }else {
	    	System.out.println("On;y one jacket foudn"+item1.getText());
	    }

	    // Print the list
	    jacketItems.forEach(System.out::println);
	    return jacketItems;
	}
 }


