package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class HomePage {
 WebDriver driver;

 By menu_lbl = By.xpath("(//li[@class='menu-item']/following::a//span)[6]");
 By newsFeature_lbl = By.xpath("(//a[@title='News & Features'])[1]");
 
 // Locator for slides
 private By slidesLocator = By.xpath("//div[@class='TileHeroStories_tileHeroStoriesButtonTitle__8Xiey']");

 public HomePage(WebDriver driver) 
 {
	 this.driver = driver;
 }

 public void hoverOverMenu() 
 {
	 WebElement menu = driver.findElement(menu_lbl);
	 Actions actions = new Actions(driver);
	 actions.moveToElement(menu).perform();
 }

 public void clickNewsFeatures() 
 {
	 driver.findElement(newsFeature_lbl).click();
 }
 

 // Method to get all slide elements
 public List<WebElement> getSlides() 
	{
	 return driver.findElements(slidesLocator);
	}
 
//Method to get titles of all slides
public String[] getSlideTitles() 
	{
		List<WebElement> slides = getSlides();
		String[] titles = new String[slides.size()];
		for (int i = 0; i < slides.size(); i++) {
		titles[i] = slides.get(i).getText().trim();
		}
		return titles;
	}
}
