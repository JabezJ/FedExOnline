Feature: Capability to utilize and order digital postal services from fedex.com

  Scenario:Fedex postal service user should be able to access Shipping menu within Fedex.com.
    Given Customer navigates to fedex.com portal homepage
    And Customer selects the dropdown menu "Shipping"
    Then Customer should have access to the following "Shipping" menu features
      | MenuOption                |
      |  Ship All Features        |
      |  Get Rates & Transit Times|
      |  Schedule & Manage Pickups|
      |  Packaging & Shipping Supplies|
      |  E-commerce|
      |  Returns|
      |  Locations|
      |  Shipping Tools|






