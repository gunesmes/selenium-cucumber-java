Feature: Review Wallethub
  As valid user
  I Want to use review feature
  So That I can post my comment

  Background: I go to Wallethub page
    Given I go to Wallethub page

  @javascript @wallethub_profile
  Scenario: I should review profile successfully
    When I hover and click 5th star
    Then I should see review page
    When I select "Health" from policy
    Then I should see "Health" is visible
    When I enter some comment on review window
    And I press submit button on review page
    Then I should see the message "you have reviewed the institution"
    When I go to my profile page
    Then I should see conformation for the review
    When I go to "activity" page
    Then I should see my comment wrote in the review page