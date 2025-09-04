package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {
 WebDriver driver;
 
 private By shop_lbl = By.xpath("(//span[.='Shop'])[1]");
 private By mens_lbl = By.xpath("(//a[@title=\"Men's\"])[1]");

 By menu_lbl = By.xpath("(//li[@class='menu-item']/following::a//span)[6]");
 By newsFeature_lbl = By.xpath("(//a[@title='News & Features'])[1]");
 
 
 
 // Locator for slides
 private By slidesLocator = By.xpath("//div[@class='TileHeroStories_tileHeroStoriesButtonTitle__8Xiey']");

 public HomePage(WebDriver driver) 
 {
	 this.driver = driver;
 }
 
 public void goToMensSection() {
     driver.findElement(shop_lbl).click();
     driver.findElement(mens_lbl).click();

     // Switch to new tab
     ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
     driver.switchTo().window(tabs.get(1));
 }

	/*
	 * public void hoverOverMenu() { WebElement menu = driver.findElement(menu_lbl);
	 * Actions actions = new Actions(driver); actions.moveToElement(menu).perform();
	 * driver.findElement(newsFeature_lbl).click(); }
	 */
 
	 public void hoverAndClickSubMenu() {
		    WebDriverWait wait = new WebDriverWait(driver, 10);
		    Actions actions = new Actions(driver);
	
		    // Hover over the main menu
		    WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(menu_lbl));
		    actions.moveToElement(menu).perform();
	
		    // Wait for the submenu to be clickable
		    WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(newsFeature_lbl));
		    subMenu.click();
		}
 

 // Method to get all slide elements
 public List<WebElement> getSlides() 
	{
	 return driver.findElements(slidesLocator);
	}
 
//Method to get titles of all slides
public String[] getSlideTitles() 
	{	
		// Locate the element using XPath
	    WebElement targetElement = driver.findElement(By.xpath("//div[.='Vote Now for a Chance to Win 76ers Tickets!']"));
	
	    // Move to the element
	    Actions actions = new Actions(driver);
	    actions.moveToElement(targetElement).perform();
	
	
			List<WebElement> slides = getSlides();
			String[] titles = new String[slides.size()];
			for (int i = 0; i < slides.size(); i++) {
			titles[i] = slides.get(i).getText().trim();
			}
			return titles;
	}
}
