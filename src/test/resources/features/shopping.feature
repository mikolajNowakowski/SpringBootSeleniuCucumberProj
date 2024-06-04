Feature: Shopping products

  @productPurchase
  Scenario Outline: I want to buy windsurfing in Egypt without logging in
qq    Given I am on the store home page
    When I click store button
    And I click on sport type from csv file at <csvRow> row
    And I add specific sport in specific region from <csvRow> row to cart
    And I go to cart
    Then I will be able to see <csvRow> in my cart
    When I proceed with shopping
    Then I will go to order form
    When I complete customer form with data from csv file at <csvRow> row
    And I complete payment details with data from csv file at <csvRow> row
    And Confirm order
    Then I will get confirmation of my order
    And I will see order details from <csvRow>

    Examples:
      | csvRow |
      | 0      |

