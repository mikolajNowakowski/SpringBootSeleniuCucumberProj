Feature: Performing operations on wish list

  Scenario Outline:I want to add one product to wish list
    Given I am on the store home page
    When I click store button
    And I click on "<sportType>"
    And I open specific "<product>"
    Then I will be on product page
    When I add product to wish list
    And I go to the wish list
    Then I will be able to see added "<product>"

    Examples:
      | sportType | product |
      |           |         |