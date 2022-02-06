Feature: Capability to utilize and order digital postal services from fedex.com

  Scenario Outline:Fedex postal service user should be able to calculate the shipping rates and transit times.
    Given Customer navigates to fedex.com portal homepage
    And Customer navigates to Calculate FedEx® shipping rates page
    When Customer calculates FedEx® shipping rates based on the following shipment attributes
      | From      | FromPostcode    | To          |  ToPostcode | PackageType      | PackageQuantity   | PackageWeight  |
      | <From>    | <FromPostcode>  |<To>         | <ToPostcode> |<PackageType>    | <PackageQuantity> | <PackageWeight>|
    Then Customer should get list of calculated rates and delivery dates for shipment

    Examples:
      | From         | FromPostcode  | To                   |  ToPostcode | PackageType           | PackageQuantity | PackageWeight|
      | United States| 10002         | United Kingdom       | SW1A2DD     | FEDEX_LARGE_BOX       |    3            |      10      |
      | United Kingdom| B912RE       | Germany              | 69190       | FEDEX_10KG_BOX        |    1            |      5       |
      | Netherlands  | 3069          | United Kingdom       | B912UN      | FEDEX_25KG_BOX        |    5            |      60      |
      |  Germany     | 68131         | United States        | 85001       | FEDEX_EXTRA_LARGE_BOX |    6            |      50     |
      | United States| 98104         | India                | 600082      | FEDEX_LARGE_BOX       |    3            |      10      |

