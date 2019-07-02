package com.payZilch;

import PageObject.HelpPage;
import PageObject.HomePage;
import PageObject.VirtualMastercardPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

/**
 * Created by Welcome on 02/07/2019.
 */
public class MyStepDefs extends Utils {

    HomePage homePage = new HomePage();
    HelpPage helpPage = new HelpPage();
    VirtualMastercardPage virtualMastercardPage = new VirtualMastercardPage();

    @Given("^User is on homepage$")
    public void user_is_on_homepage()  {
        assertEquals("PayZilch | Have what you want. When you want.",homePage.getTitle());
    }

    @When("^User click on Login link$")
    public void user_click_on_Login_link()  {
        homePage.clickOnLogin();
    }

    @Then("^User should be navigated to login page$")
    public void user_should_be_navigated_to_login_page()  {
       homePage.assertUrl();
    }

    @When("^User clicks on help link$")
    public void userClicksOnHelpLink(){
        homePage.clickOnHelp();
    }

    @And("^User navigates to help page$")
    public void userNavigatesToHelpPage(){
       // assertEquals("Log in - Zilch Customer Portal",homePage.getTitle());

    }

    @And("^User clicks on Zilch Virtual Mastercard Use$")
    public void userClicksOnZilchVirtualMastercardUse() {
        helpPage.clickZilchMastercard();
    }

    @Then("^User should be able to navigate to Zilch Virtual Mastercard use page$")
    public void userShouldBeAbleToNavigateToZilchVirtualMastercardUsePage() {
        virtualMastercardPage.assertVirtualMastercardHeading();
    }
}
