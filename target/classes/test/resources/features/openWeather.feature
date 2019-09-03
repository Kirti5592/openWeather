@open
Feature: OpenWeather site check

  Background:
    Given user clicks on the openWeather link

  @scenario1
  Scenario Outline: To check working of the openWeather page
    Given user is able to see the home page
    When user is on Home page
    Then the page should contain "<label>"

    Examples:
    |label                |
    |openWeather          |
    |Weather in your city |
    |Sign In              |
    |Sign Up              |

  @scenario2
  Scenario: To check the error message for wrong city name
    Given user is on Home Page
    When user enters the name of an invalid city
    Then message is displayed "Not Found"

  @scenario3
  Scenario: To check the information is displayed when valid city name is entered
    Given user is on Home Page
    When user enters the name of a city
    Then the weather details of the city is displayed

  @scenario4
  Scenario: To check the functioning of API
    Given user is on Home Page
    And user clicks on API link
    When the user navigates to the API weather page
    Then the user should get a message for sign up or monthly subscription