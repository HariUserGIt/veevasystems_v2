package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ExpectedTitles;
import base.BaseTest;

public class SlideValidationTest extends BaseTest {

	 @Test
	 public void validateSlideTitles() 
	 {
		 driver.get("https://www.nba.com/sixers/");
		 HomePage homePage = new HomePage(driver);
		 String[] actualTitles = homePage.getSlideTitles();
		 String[] expectedTitles = ExpectedTitles.titles;
		
		 System.out.println("Total Slides Found: " + actualTitles.length);
		
		 for (int i = 0; i < actualTitles.length; i++) {
		 System.out.println("Slide " + (i + 1) + ": " + actualTitles[i]);
		 if (i < expectedTitles.length) 
		 {
			 Assert.assertEquals(actualTitles[i], expectedTitles[i], "Mismatch at Slide " + (i + 1));
			 } else 
			 {
				 System.out.println("No expected title provided for Slide " + (i + 1));
			 }
		 }
	 }

}