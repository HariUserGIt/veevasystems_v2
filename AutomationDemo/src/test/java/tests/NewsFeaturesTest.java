package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsFeaturesPage;
import base.BaseTest;

import io.qameta.allure.*;

@Epic("NBA Automation")
@Feature("News & Features Section")
public class NewsFeaturesTest extends BaseTest {

    @Test(description = "Verify video count on News & Features page")
    @Story("Validate News & Features content")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test navigates to Warriors homepage, goes to News & Features section, " +
                 "counts the videos displayed, and asserts that at least one video exists.")
    public void testVideoCountOnNewsFeaturesPage() throws InterruptedException {

        Allure.step("Navigate to Warriors homepage");
        driver.get("https://www.nba.com/warriors");
        driver.findElement(By.xpath("(//div[.='x'])[2]")).click();

        Allure.step("Initialize page objects");
        HomePage homePage = new HomePage(driver);
        NewsFeaturesPage newsPage = new NewsFeaturesPage(driver);

        Allure.step("Hover and click on News & Features submenu");
        homePage.hoverAndClickSubMenu();
        Thread.sleep(2000); // Optional: wait for dropdown to appear

        Allure.step("Count number of videos on News & Features page");
        int videoCount = newsPage.getVideoCount();
        Allure.addAttachment("Video Count", String.valueOf(videoCount));

        Allure.step("Validate video count is greater than zero");
        Assert.assertTrue(videoCount > 0, "No videos found on News & Features page.");
    }
}
