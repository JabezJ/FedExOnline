Feature: Capability to list products for a swiss customer in the OC2 Product Overview Page

  Scenario Outline:Swiss customer should be able to get list of products
    Given a Swiss customer purchases digital services from OC2 connect shop
      | userEmail   |
      | <userEmail> |
    And the available products are listed in the product overview page

    Examples:
      | userEmail                                  |
      | testuser.int.CH.001@mbox.mercedes-benz.io  |
