package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.*;

import pages.HomePage;
import utils.ExpectedTitles;

public class SlideValidationTest extends BaseTest {

    @Test(description = "Validate Slide Titles on NBA Sixers Page")
    @Epic("NBA Automation")
    @Feature("Home Page Slides")
    @Story("Validate Slide Titles")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that slide titles match the expected ones from ExpectedTitles class.")
    public void validateSlideTitles() throws InterruptedException {
        driver.get("https://www.nba.com/sixers/");
        HomePage homePage = new HomePage(driver);
        String[] actualTitles = homePage.getSlideTitles();
        String[] expectedTitles = ExpectedTitles.titles;

        System.out.println("Total Slides Found: " + actualTitles.length);

        for (int i = 0; i < actualTitles.length; i++) {
            System.out.println("Slide " + (i + 1) + ": " + actualTitles[i]);
            if (i < expectedTitles.length) {
                Thread.sleep(2000);
                Assert.assertEquals(actualTitles[i], expectedTitles[i], "Mismatch at Slide " + (i + 1));
            } else {
                System.out.println("No expected title provided for Slide " + (i + 1));
            }
        }
    }
}
