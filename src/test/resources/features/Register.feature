@TestLogin
Feature: Test Register in Automation Demo Site website

  Background: registration
    Given User on Page Automation Demo Site
    When User click skip to sign in
    Then User will be redirected to Register page

  @TestRun
  Scenario: Successfully Register new member.
    When User input "FullName" value
    And User input "Address" value
    And User input "Email" value
    And User input "Phone" value
    And User select gender "Male"
    And User select hobbies "Movies"
    And User select language "Arab"
    And User select skills "APIs"