Feature: Register functionality
  Background:
    Given User is on homepage

  @test
  Scenario: Navigate to login page
    When User click on Login link
    Then User should be navigated to login page

  @test
  Scenario: User navigates to Virtual Mastercard to view product details
  When User clicks on help link
  And User navigates to help page
  And User clicks on Zilch Virtual Mastercard Use
  Then User should be able to navigate to Zilch Virtual Mastercard use page
