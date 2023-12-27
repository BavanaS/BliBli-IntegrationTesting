Feature: Integration Testing in BliBli

  Scenario: Fetching the keywords from the website
    When Fetch the list of keywords from the website "https://wwwpreprod.gdn-app.com/backend/search/getSeedKeyword"
    Then Get the first keyword from the list

  Scenario: Place and cancel the order using the fetched keyword
    Given Open the BliBli website "https://wwwpreprod.gdn-app.com/"
    When Provide the login credentials username "+6281234500001" and password "Test@1234"
    And Provide the otp "3" "3" "3" "3"
    Then get login successful
    When Provide the fetched keyword and search
    Then Display the page after applying "Disediakan Blibli" filter
    When Select "2" fourth product from the product page and go to product details page and enter quantity of the product 2
    Then Checkout the selected product
    When Change the provided address to "Jakarta" for checkout
    And Change the payment method to bank "Bank BNI"
