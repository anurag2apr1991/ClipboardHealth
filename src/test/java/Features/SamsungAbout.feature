Feature: Test the Functionality of Amazon Home Page

  @SamsungAbout
  Scenario Outline: Verify the functionality of Television of Amazon.in
    #Given User Enter the amazon webpage URL
    Then User landed on the amazon website according to region of user
    Then user verify the user present on home page
    When user click on hamburger icon
    Then verify the "<categoryName>" with "<subCategoryName>" name is visible
    When user click on "<subSubCategoryName>" with "<productType>" name
    Then verify user landed on the correct "<productType>" name
    Then Scroll to the Brand Names Heading
    When User Click on the "<Brand Name>"
    Then User Click on the Sort the according to price by High To Low
    When User Click on the Second Highest TV
    Then The Page of the Second Highest Page is open
    Then Display the About this item into the scroll
    Examples:
      | Brand Name | categoryName     | subCategoryName             | subSubCategoryName  | productType |
      | Samsung    | shop by category | TV, Appliances, Electronics | tv, audio & cameras | Televisions |



