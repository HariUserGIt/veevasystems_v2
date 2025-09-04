package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class NewsFeaturesPage 
{
	 WebDriver driver;
	
	 By videos = By.xpath("//a[@class='TileArticle_tileLink__dBHYH']");
	
	 public NewsFeaturesPage(WebDriver driver) {
	 this.driver = driver;
	 }
	
	 public int getVideoCount() {
	 List<WebElement> videoList = driver.findElements(videos);
	 return videoList.size();
	 }
}

