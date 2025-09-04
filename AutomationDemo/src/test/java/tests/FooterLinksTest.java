package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FooterPage;
import utils.CSVUtils;

public class FooterLinksTest extends BaseTest {

	 @Test
	 public void extractFooterLinksAndCheckDuplicates() throws IOException {
		 test = extent.createTest("Slide Title Validation Test");

		 driver.get("https://www.nba.com/bulls/");
		 test.info("Navigated to Sixers homepage");

		 FooterPage footerPage = new FooterPage(driver);
	
		 // Scroll to footer
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
		// Wait for footer to load
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Team']")));
	
	
		 List<String> allLinks = footerPage.getAllFooterLinks();
	
		 // Save to CSV
		 String filePath = "footer_links.csv";
		 CSVUtils.writeLinksToCSV(allLinks, filePath);
		 }
	}
