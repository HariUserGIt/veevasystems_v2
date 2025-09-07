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

import io.qameta.allure.*;

@Epic("NBA Automation")
@Feature("Footer Links Validation")
public class FooterLinksTest extends BaseTest {

    @Test(description = "Extract footer links from Bulls page and check for duplicates")
    @Story("Validate footer links and store them in CSV")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test scrolls to the footer of the NBA Bulls page, extracts all footer links, " +
                 "saves them to a CSV file, and prepares for duplicate validation.")
    public void extractFooterLinksAndCheckDuplicates() throws IOException {

        Allure.step("Navigate to NBA Bulls homepage");
        driver.get("https://www.nba.com/bulls/");

        FooterPage footerPage = new FooterPage(driver);

        Allure.step("Scroll to footer section");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Allure.step("Wait for footer to load");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Team']")));

        Allure.step("Extract all footer links");
        List<String> allLinks = footerPage.getAllFooterLinks();

        // Save to CSV
        String filePath = "footer_links.csv";
        CSVUtils.writeLinksToCSV(allLinks, filePath);

        // Attach footer links list to Allure report
        Allure.addAttachment("Extracted Footer Links", String.join("\n", allLinks));

        // Attach CSV path
        Allure.addAttachment("CSV File Path", filePath);
    }
}
