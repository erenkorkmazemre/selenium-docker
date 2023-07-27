@RunAll
Feature: Feature Cases

  Background:
    Given Go to address
    When Check if "Login" options exist with "loginTitle" on page
    And Check "Service" service exist on page
    And Check "foodService" service exist on page
    And Check "moreService" service exist on page
    And Check "waterService" service exist on page
    
  Scenario Outline: Case 1
    And Check if "Categories" and items are "CATEGORIES" listed
    And Change the website language
    And Check if "<language>" options exist with "languageTitle" on page
    Examples:
      | language    |
      | Türkçe (TR) |

  Scenario Outline: Case 2
    And Choose a random category from the "CATEGORIES" and check if exist
    And Check if "<Categories>" options exist with "categoriesSubTitle" on page
    And Select one of the subcategories under a random category "CATEGORIES"
    Examples:
      | Categories |
      | categories |

  Scenario Outline: Case 3
    And  Change the service to "food"
    And  Check if "Cuisines" options exist with "foodHomePage" on page
    And  Choose one of the "<cuisines>" from "cuisinesTitle"
    And  Check if "Add Delivery Address" options exist with "addDeliveryAddressTitle" on page
    And  Drag the house icon pinned on the map somewhere "mapTitle" on the map
    And  Check if "Drag pin to select address" options not exist with "addressTitle" on page
    And  Click the "Use this address" button
    And  Send keys into "<building>" "<floor>" "<no>" "<description>" for delivery
    And  Click the "Save" button
    And  Click the "Yes" button
    And  Click the first restaurant
    And  Check if "Your basket is empty" options exist with "rightCard" on page
    And  Click the random "Add" button

    Examples:
      | cuisines | building | floor | no | description |
      | Doner    | 12       | 3     | 11 |  Home  |
      | Burger   | 11       | 3     | 4  | Istanbul    |
      | Fish     | 4        | 32    | 1  | Ankara      |
      | Borek    | 43       | 41    | 4  | Izmir       |
      | Kebab    | 1        | 2     | 33 | Mersin      |
