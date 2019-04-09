Feature: Login to Facebook
  As valid user
  I Want see my account
  So That I can login to Facebook with e-mail and password

  Background: I go to Facebook login page
    Given I go to Facebook login page

  @javascript @facebook_login
  Scenario: I should login successfully
    When I enter email as "morhipojohndoe@gmail.com"
    And I enter password as "EnterPassWord"
    And I click on login button
    Then I should see my name "MorhipoTest" on the page
    When I post "Hello World" to Facebook
    Then I see that "Hello World" is visible on my profile