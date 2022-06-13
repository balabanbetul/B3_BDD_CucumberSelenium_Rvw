Feature: Menu List
  @menu
  Scenario: Verify menu List
    When the user is on the login page
    And the user enters valid credentials
    Then verify "Phones" "Laptops" "Monitors" in categories Menu


  @menu2
  Scenario: Add new credential to the Configuration Properties

    Given the user is on the login page
    When the user enters valid credentials
    Then the user able to see following categories
      |Phones|
      |Laptops|
      |Monitors|
@conf
    Scenario: Add new credential to the Configuration properties
      Given the user is on the login page
      When the user enters valid credentials
      And the user get laptops name
      Then the compiler adds laptops name tothe Configuration properties

