Feature: Capability to utilize and order digital postal services from fedex.com

  Scenario:Fedex postal service user should be able to to access Support menu with in Fedex.com.
    Given Customer navigates to fedex.com portal homepage
    And Customer selects the dropdown menu "Support"
    Then Customer should have access to the following "Support" menu features
      | MenuOption                |
      | New Customer Centre       |
      |  Customs Clearance        |
      |  Small Business Hub       |
      |  Claims                   |
      | FAQs                      |
      | Contact Us                |




