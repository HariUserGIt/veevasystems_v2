package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MensJacketsPage;
import utils.FileUtils;

import java.util.List;

import io.qameta.allure.*;

@Epic("NBA Automation")
@Feature("Men's Jackets")
public class JacketsDataTest extends BaseTest {

    @Test(description = "Extract and validate most popular men's jackets")
    @Story("Extract men's jacket data from Warriors store")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Opens Warriors homepage, navigates to Men's Jackets section, extracts jacket details, saves to file, and validates data.")
    public void extractJacketDetails() {

        Allure.step("Step 1: Open Warriors homepage");
        driver.get("https://www.nba.com/warriors");
        driver.findElement(By.xpath("(//div[.='x'])[2]")).click();

        Allure.step("Step 2: Navigate to Men's Section");
        HomePage home = new HomePage(driver);
        home.goToMensSection();

        Allure.step("Step 3: Extract Jacket Data");
        MensJacketsPage jacketsPage = new MensJacketsPage(driver);
        List<String> jacketsData = jacketsPage.getMostPopularJackets(driver);

        Assert.assertTrue(jacketsData.size() > 0, "No jackets found!");
        Allure.step("Jackets found: " + jacketsData.size());

        Allure.step("Step 4: Save jacket details to file");
        String filePath = FileUtils.writeToFile(jacketsData, "jackets.txt");

        // Attach extracted data to Allure report
        Allure.addAttachment("Extracted Jacket Details", String.join("\n", jacketsData));

        // Attach file path as text
        Allure.addAttachment("Saved File Path", filePath);
    }
}
