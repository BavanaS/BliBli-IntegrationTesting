Feature: Integration Testing in BliBli

  Scenario: Fetching the keywords from the website
    When Fetch the list of keywords from the website "https://wwwpreprod.gdn-app.com/backend/search/getSeedKeyword"
    Then Get the first keyword from the list

  Scenario Outline: Place and cancel the order using the fetched keyword
    Given Open the BliBli website "https://wwwpreprod.gdn-app.com/"
    When Provide the login credentials username "<username>" and password "<password>"
    And Provide the otp "<otp1>" "<otp2>" "<otp3>" "<otp4>"
    Then get login successful
    When Provide the fetched keyword and search
    Then Display the page after applying "<filter>" filter
    When Select "<orderOfProduct>" order of product from the product page and go to product details page and enter quantity of the product 2
    Then Checkout the selected product
    When Change the provided address to "<mainAddress>" and provide details label "<label>", name "<name>", mobile number "<mobileNo>" for checkout
    And Change the payment method to bank "<bankName>"
    And Change the shipping to "<shipping>"
    And Place the order
    And Cancel the order from Thank you page
    Then Verify if the order is cancelled in order detail page
    Examples:
     |username      |password |otp1|otp2|otp3|otp4|filter           |orderOfProduct|mainAddress|label|name |mobileNo     |bankName|shipping|
     |+6281234500001|Test@1234| 3  |  3 |3   | 3  |Disediakan Blibli|1             |Jakarta    |Work |Jwala|6281234500001|Bank BNI|BFB     |
