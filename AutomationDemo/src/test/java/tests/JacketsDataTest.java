package tests;

import base.BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MensJacketsPage;
import utils.FileUtils;

import java.util.List;

public class JacketsDataTest extends BaseTest {

    @Test
    public void extractJacketDetails() {
        test = extent.createTest("Extract Jacket Details");

        // Step 1: Open Home Page
        driver.get("https://www.nba.com/warriors");
        driver.findElement(By.xpath("(//div[.='x'])[2]")).click();
        test.info("Opened Warriors homepage");

        // Step 2: Navigate to Men's Section
        HomePage home = new HomePage(driver);
        home.goToMensSection();
        test.info("Navigated to Men's section");

        // Step 3: Extract Jacket Data
        MensJacketsPage jacketsPage = new MensJacketsPage(driver);
        List<String> jacketsData = jacketsPage.getMostPopularJackets(driver);
        test.info("Extracted jacket data");

        Assert.assertTrue(jacketsData.size() > 0, "No jackets found!");
        test.pass("Jackets found: " + jacketsData.size());

        // Step 4: Save to file
        String filePath = FileUtils.writeToFile(jacketsData, "jackets.txt");
        test.info("Saved jacket data to file: " + filePath);

        // Step 5: Attach to Extent Report
        test.pass("Jacket details extracted successfully")
            .addScreenCaptureFromPath(filePath);
    }
}
