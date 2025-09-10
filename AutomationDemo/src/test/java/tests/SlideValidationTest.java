package tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void validateSlideTitles4() throws InterruptedException {
        driver.get("https://www.nba.com/sixers");
        HomePage homePage = new HomePage(driver);

        String[] actualTitles = homePage.getSlideTitles();
        String[] expectedTitles = ExpectedTitles.titles;

        System.out.println("Actual Titles: " + Arrays.toString(actualTitles));
        System.out.println("Expected Titles: " + Arrays.toString(expectedTitles));

        // Convert to Sets
        Set<String> actualSet = new HashSet<>(Arrays.asList(actualTitles));
        Set<String> expectedSet = new HashSet<>(Arrays.asList(expectedTitles));

        // Assert that actual contains all expected
        Assert.assertTrue(actualSet.containsAll(expectedSet),
            "Actual titles do not contain all expected titles!\nMissing: " 
            + expectedSet.removeAll(actualSet));
    }


}
