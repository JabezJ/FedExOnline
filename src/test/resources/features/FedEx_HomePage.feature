Feature: Capability to utilize and order digital postal services from fedex.com

  Scenario:Fedex postal service user should be able to utilize the tracking and shipping services on homepage.
    Given Customer would like to utilize digital postal services from fedex.com
    When Customer navigates to fedex.com portal homepage
    Then Customer should see the digital postal services to calculate,track and ship
    And Customer should see the tracking service selected as default
