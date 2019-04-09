package com.wallethub.assignment;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by mesutgunes on 04/07/17.
 */
public class FacebookLogin {

    public WebDriver driver = Hooks.driver;

    @Given("^I go to Facebook login page$")
    public void iGoToFacebookLoginPage() throws Throwable {
        driver.navigate().to("https://www.facebook.com");
        Assert.assertTrue(driver.getTitle().contains("Facebook – log in or sign up"));
    }

    @When("^I enter email as \"([^\"]*)\"$")
    public void iEnterEmailAs(String email) throws Throwable {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password) throws Throwable {
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() throws Throwable {
        driver.findElement(By.id("loginbutton")).click();
    }

    @Then("^I should see my name \"([^\"]*)\" on the page$")
    public void iShouldSeeMyNameOnThePage(String name) throws Throwable {
        Helpers.waitSelectorVisible(driver, By.id("fbRequestsJewel"));

        Assert.assertTrue(driver.findElement(By.id("pagelet_bluebar")).getText().contains(name));
    }

    @When("^I post \"([^\"]*)\" to Facebook$")
    public void iPostToFacebook(String message) throws Throwable {
        Helpers.waitSelectorVisible(driver, By.id("feedx_sprouts_container"));

        driver.findElement(By.cssSelector(".linkWrap.noCount")).click();

        Helpers.waitSelectorVisible(driver, By.id("timeline_react_composer_container"));

        driver.findElement(By.xpath("//*[@name='xhpc_message_text']")).click();
        driver.findElement(By.xpath("//*[@name='xhpc_message_text']")).sendKeys(message);

        Helpers.waitSelectorVisible(driver, By.cssSelector("button[data-testid='react-composer-post-button']"));
        driver.findElement(By.cssSelector("button[data-testid='react-composer-post-button']")).click();

        Helpers.waitSelectorVisible(driver, By.xpath("//span[@class='timestampContent' and text()='Just now']"));
    }

    @Then("^I see that \"([^\"]*)\" is visible on my profile$")
    public void iSeeThatIsVisibleOnMyProfile(String message) throws Throwable {
        List<WebElement> posts = driver.findElements(By.xpath("//div[contains(@class, 'fbUserContent')]"));
        Assert.assertTrue(posts.get(0).getText().contains(message));
    }

}
