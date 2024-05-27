Feature: Shopping products

  @windsurfingShipment
  Scenario Outline: I want to buy windsurfing in Egypt without logging in
    Given I am on the store home page
    When I click store button
    And I click on "<sportType>"
    And I add "<region>" "<sportType>" to cart
    And I go to cart
    Then I will be able to see "<region>" windsurfing in my cart
    When I proceed with shopping
    Then I will go to order form
    When I complete customer form
      | firstName     | lastName     | companyName     | country     | address1     | address2     | postCode     | city     | phoneNumber     | email     | createAccount     | additionalComments     | termsAcceptation     |
      | "<firstName>" | "<lastName>" | "<companyName>" | "<country>" | "<address1>" | "<address2>" | "<postCode>" | "<city>" | "<phoneNumber>" | "<email>" | "<createAccount>" | "<additionalComments>" | "<termsAcceptation>" |
    And I complete payment details
      | cardNumber     | cardExpirationDate     | cvcNumber     |
      | "<cardNumber>" | "<cardExpirationDate>" | "<cvcNumber>" |
    And Confirm order
    Then I will get confirmation of my order

    Examples:
      | sportType   | region | firstName | lastName | companyName | country | address1          | address2 | postCode | city      | phoneNumber | email               | createAccount | additionalComments | termsAcceptation | cardNumber       | cardExpirationDate | cvcNumber |
      | Windsurfing | Egipt  | Lary      | Smith    | Cognizant   | Poland  | Baker street 2/3B |          | 11-111   | Bydgoszcz | 222-222-222 | larySmith@gmail.com |               |                    | true             | 4242424242424242 | 05/2030            | 555       |


