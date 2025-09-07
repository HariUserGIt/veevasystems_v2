package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsFeaturesPage;
import base.BaseTest;

public class NewsFeaturesTest extends BaseTest {

	 @Test
	 public void testVideoCountOnNewsFeaturesPage() throws InterruptedException 
	 {
		 driver.get("https://www.nba.com/warriors");
		 driver.findElement(By.xpath("(//div[.='x'])[2]")).click();
		 
		 HomePage homePage = new HomePage(driver);
		 NewsFeaturesPage newsPage = new NewsFeaturesPage(driver);
		
		 homePage.hoverAndClickSubMenu();
		 Thread.sleep(2000); // Optional: wait for dropdown to appear
		
		
		 int videoCount = newsPage.getVideoCount();
		 System.out.println("Number of videos found: " + videoCount);
		
		 Assert.assertTrue(videoCount > 0, "No videos found on News & Features page.");
		 }
	}

