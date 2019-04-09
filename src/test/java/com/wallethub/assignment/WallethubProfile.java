package com.wallethub.assignment;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by mesutgunes on 05/07/17.
 */
public class WallethubProfile {

    public WebDriver driver = Hooks.driver;

    class Rates {
        String num_start;
        String message;
    }


    @Given("^I go to Wallethub page$")
    public void iGoToWallethubPage() throws Throwable {
        driver.navigate().to("http://wallethub.com/profile/test_insurance_company/");
        Helpers.waitSelectorVisible(driver, By.cssSelector(".reviewinfo.info"));

        Assert.assertTrue(driver.getTitle().contains("Test Insurance Company Reviews:"));
    }

    @When("^I hover and click (\\d+)th star$")
    public void iHoverAndClickThStar(int arg0) throws Throwable {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(".wh-rating.rating_4_5"))).perform();

        WebElement oneStar =  driver.findElement(By.cssSelector(".wh-rating-choices-holder > a:nth-child(1)"));
        WebElement twoStar =  driver.findElement(By.cssSelector(".wh-rating-choices-holder > a:nth-child(2)"));
        WebElement threeStar =  driver.findElement(By.cssSelector(".wh-rating-choices-holder > a:nth-child(3)"));
        WebElement fourStar =  driver.findElement(By.cssSelector(".wh-rating-choices-holder > a:nth-child(4)"));
        WebElement fiveStar =  driver.findElement(By.cssSelector(".wh-rating-choices-holder > a:nth-child(5)"));

        action.moveToElement(oneStar).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector(".wh-rating-choices-holder > em")).getText().contains("Bad"));

        action.moveToElement(twoStar).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector(".wh-rating-choices-holder > em")).getText().contains("Below Avarage"));

        action.moveToElement(threeStar).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector(".wh-rating-choices-holder > em")).getText().contains("Avarage"));

        action.moveToElement(fourStar).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector(".wh-rating-choices-holder > em")).getText().contains("Good"));

        action.moveToElement(fiveStar).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector(".wh-rating-choices-holder > em")).getText().contains("Excellent"));

        fiveStar.click();
        Helpers.waitSelectorVisible(driver, By.id("review-product"));
    }


    @Then("^I should see review page$")
    public void iShouldSeeReviewPage() throws Throwable {
        Assert.assertTrue(driver.findElement(By.cssSelector(".dropdown-title")).getText().contains("Please select your policy"));
    }

    @When("^I select \"([^\"]*)\" from policy$")
    public void iSelectFromPolicy(String opt) throws Throwable {
        driver.findElement(By.cssSelector(".dropdown-title")).click();
        driver.findElement(By.cssSelector(String.format("a[data-target='%s']", opt))).click();
        Helpers.waitSelectorInVisible(driver, By.cssSelector(".loading-image"));
    }

    @Then("^I should see \"([^\"]*)\" is visible$")
    public void iShouldSeeIsVisible(String opt) throws Throwable {
        Assert.assertTrue(driver.findElement(By.cssSelector(".val")).getText().contains(opt));
    }

    @When("^I enter some comment on review window$")
    public void iEnterSomeCommentOnReviewWindow() throws Throwable {
        String comment = "We open in battle between rebels and Romans. Pollux and Rabanus are easily killing Roman guards. Gannicus tells a Roman lord to spread the word to free the slaves or see more destruction. The Roman asks who he is and he says \"I am Spartacus.\" This turns out to be a strategic plan by Spartacus as \n" +
                "Bscap0004\n" +
                "\"I am Spartacus\".\n" +
                "other battles across the land with various Rebels proclaiming the same, including Nasir, Lugo, Pleuratos, and Spartacus himself.\n" +
                "Crassus and Caesar can't believe they're all Spartacus of course, but a strategy to throw off Pompey. Crassus looks thoughtfully at a mold of Tiberius' face and Crassus is set on getting his revenge.";

        driver.findElement(By.id("review-content")).clear();
        driver.findElement(By.id("review-content")).click();
        driver.findElement(By.id("review-content")).sendKeys(comment);

    }

    @And("^I press submit button on review page$")
    public void iPressSubmitButtonOnReviewPage() throws Throwable {
        driver.findElement(By.cssSelector(".overallRating > a:nth-child(5)")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Then("^I should see the message \"([^\"]*)\"$")
    public void iShouldSeeTheMessage(String arg0) throws Throwable {
        Helpers.waitSelectorVisible(driver, By.cssSelector(".ng-animate-enabled.basic-trans.enter"));
        driver.findElement(By.xpath("//a[text='Login']")).click();
        driver.findElement(By.cssSelector("input[name='em']")).sendKeys("gunesmes@gmail.com");
        driver.findElement(By.cssSelector("input[name='pw1']")).sendKeys("Aa121212!");
        driver.findElement(By.cssSelector(".btn.blue.touch-element-cl")).click();
        Helpers.waitSelectorInVisible(driver, By.cssSelector(".bf-icon-spin5.animate-spin"));
    }

    @When("^I go to my profile page$")
    public void iGoToMyProfilePage() throws Throwable {
        Helpers.waitSelectorVisible(driver, By.id("reviews"));
    }

    @Then("^I should see conformation for the review$")
    public void iShouldSeeConformationForTheReview() throws Throwable {

    }

    @When("^I go to \"([^\"]*)\" page$")
    public void iGoToPage(String page) throws Throwable {
        driver.navigate().to(String.format("http://wallethub.com/gunesmes/%s/", page));
        Helpers.waitSelectorVisible(driver, By.cssSelector(".profilenav"));

        driver.findElement(By.cssSelector(".profilenav > ul > li:nth-child(3) > a")).click();
        Helpers.waitSelectorVisible(driver, By.cssSelector(".reviews"));
    }

    @Then("^I should see my comment wrote in the review page$")
    public void iShouldSeeMyCommentWroteInTheReviewPage() throws Throwable {
        String commentPart = "We open in battle between rebels and Romans. Pollux and Rabanus are easily killing Roman guards. Gannicus tells a Roman lord to spread the word to free the slaves or see more destruction. The Roman asks who he is and he says \"I am Spartacus.\" This turns out to be a strategic plan by Spartacus as \n";

        Assert.assertTrue(driver.findElement(By.cssSelector(".reviews > div:nth-child(1)")).getText().contains(commentPart));
    }

}
