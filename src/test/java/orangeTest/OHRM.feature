@OrangeHRM
Feature: Validating Functionalities of OrangeHRM
  

  @Login
  Scenario: Validate login page
    Given User is on OrangeHRM website<browser>
    When Valid Login id and password are entered
    Then Login is Successful
  Examples:
  |browser|
  |edge|
    

  @Adduser
  Scenario: Adding a new user and display list
    Given User is on Admin/User management page
    When All the mandatory fields are filled
    Then User is created
    
  @Deleteuser
  Scenario: Deleting a new user and display list
    Given User is on Admin/User management page
    When User is selected and clicked delete
    Then User is deleted
