Feature: Capability to utilize and order digital postal services from fedex.com

  Scenario:Fedex postal service user should be able to access Tracking menu within Fedex.com.
    Given Customer navigates to fedex.com portal homepage
    And Customer selects the dropdown menu "Tracking"
    Then Customer should have access to the following "Tracking" menu features
      | MenuOption                  |
      |  Customised FedEx Tracking  |
      |  FedEx Insight              |
      |  All Tracking Services      |






