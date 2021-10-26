Feature: Verify ColoursLovers Pattern

  Scenario: Get the Colourlovers Pattern numViews
    Given User set the base URL for ColoursLovers
    When User send request to GET Pattern
    Then User validate the numViews Greater than 4000
