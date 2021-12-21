Feature: Capability to order digital services from OC2 MB connect shop

  Scenario Outline:As a Portuguese OC2 shop visitor when purchasing digital services I would like to check-out and confirm the order.
    Given Customer navigates to OC2 connect shop page of "<country>" rollout market
    And Customer logs into OC2 connect shop of "<country>" rollout market
    When Customer adds the digital service to the OC2 connect shopping cart
      | vehicle         | product        |
      | <vehicle>       | <product>      |
    Then the customer should be able to check out the shopping cart
    And the customer should be able to verify and confirm the order
    And Customer logsout of OC2 connect shop

    Examples:
      |country    | vehicle                  | product               |
      | portugal  | WDD 177 084-2Z-000017    | Hard-disc-navigation  |
