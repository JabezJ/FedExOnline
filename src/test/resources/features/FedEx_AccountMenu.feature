Feature: Capability to utilize and order digital postal services from fedex.com

  Scenario:Fedex postal service user should be able to access Account menu within Fedex.com.
    Given Customer navigates to fedex.com portal homepage
    And Customer selects the dropdown menu "Account"
    Then Customer should have access to the following "Account" menu features
      | MenuOption                |
      | FedEx Billing Online      |
      | Manage Reporting Online   |
      | FedEx Administration      |
      | My Profile                |
      | Email Preferences         |
      | Address Book              |
      | Open an Account           |




