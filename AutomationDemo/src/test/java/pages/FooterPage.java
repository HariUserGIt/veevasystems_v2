package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import utils.ExpectedTitles;

public class FooterPage extends BaseTest{
 private WebDriver driver;

	 public FooterPage(WebDriver driver) 
	 {
		 this.driver = driver;
	 }
	
	 private By teamLinks = By.xpath("//h2[.='Team']/..//ul//li//a");
	 private By ticketLinks = By.xpath("//h2[.='Tickets']/..//ul//li//a");
	 private By shopLinks = By.xpath("//h2[.='Shop']/..//ul//li//a");
	 private By communityLinks = By.xpath("//h2[.='Community']/..//ul//li//a");
	 private By unitedCenterLinks = By.xpath("//h2[.='United Center']/..//ul//li//a");
	 private By newsLinks = By.xpath("//h2[.='News']/..//ul//li//a");
	
	 public List<String> getAllFooterLinks() 
	 {
		 List<By> sections = Arrays.asList(teamLinks, ticketLinks, shopLinks, communityLinks, unitedCenterLinks, newsLinks);
		 List<String> allLinks = new ArrayList<>();
		
		
		 for (By section : sections) 
		 {
			 List<WebElement> links = driver.findElements(section);
			 for (WebElement link : links) 
			 {
				 String href = link.getAttribute("href");
				 if (href != null && !href.isEmpty()) 
					 {
						 allLinks.add(href.trim());
					 }
			 }
		 }
		 return allLinks;
	 }
}

