Feature: Capability to utilize and order digital postal services from fedex.com

  Scenario:Fedex postal service user should be able to ship postal with Fedex.com.
    Given Customer navigates to fedex.com portal homepage
    And Customer navigates to Calculate FedEx® shipment page
    When Customer attempts to log into fedex.com portal account
    And Customer should be successfully logged in
