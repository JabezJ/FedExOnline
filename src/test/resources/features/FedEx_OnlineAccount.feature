Feature: Capability to utilize and order digital postal services from fedex.com

  Scenario: Fedex postal customers should be able to log into online account.
    Given Customer navigates to fedex.com portal homepage
    When Customer attempts to log into fedex.com portal account
    Then Customer should be successfully logged in

  Scenario Outline: Fedex postal customers should not be able to log into online account with invalid credentials.
    Given Customer navigates to fedex.com portal homepage
    When Customer attempts to log into fedex.com portal account with credentials "<User>" and "<Password>"
    Then Customer should not be logged in

    Examples:
      | User         | Password  |
      | JabezJ       | fed12345  |
      | Jabez        | Fed12345  |

  Scenario:Fedex postal customers should be able to log out of online account.
    Given Customer navigates to fedex.com portal homepage
    And Customer attempts to log into fedex.com portal account
    And Customer should be successfully logged in
    When Customer attempts to log out of fedex.com portal account
    Then Customer should be successfully logged out
