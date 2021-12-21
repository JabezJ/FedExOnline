Feature: Capability to calculate taxes for order during checkout process for a canadian customer

  Scenario Outline:Canadian customer should be able to get full transparency about the tax structure
    Given a Canadian customer purchases digital services from connect shop
      | userEmail   |
      | <userEmail> |
    When the customer checks out the digital services with order value of <totalPrice>
    Then the correct value of <federalTaxes> and <provincialTaxes> are calculated

    Examples:
      | userEmail                                  |totalPrice |federalTaxes|provincialTaxes|
      | testuser.int.CA.001@mbox.mercedes-benz.io  |$CA49.95   | $CA2.50    |   $CA4.98     |
