Feature: Capability to utilize and order digital postal services from fedex.com

  Scenario Outline:Fedex postal service user should be able to track the postal shipment.
    Given Customer navigates to fedex.com portal homepage
    And Customer should see the tracking service selected as default
    When Customer attempts to track the postal by tracking number "<TrackingNumber>"
    Then Customer should be able to see the shipment status
    Examples:
      | TrackingNumber  |
      | 449044304137821 |
      | 020207021381215 |
      | 403934084723025 |
