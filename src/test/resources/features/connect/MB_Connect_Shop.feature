Feature: Capability to order digital services from MB connect shop

# Scenario: Login to order digital service from MB connect shop
 #   Given Customer navigates to MB connect shop page
  #  And  Customer logs into MB connect shop
   # And  Customer could log out of the MB connect shop

  Scenario Outline:As a Canadian shop visitor when purchasing digital services I would like to see the correct tax amount next to the net price in order to get full transparency about the price structure.
    Given Customer navigates to MB Canadian shop page
    And Customer logs into MB Canadian connect shop
    When Customer adds the digital service to the shopping cart
      | product        |
      | <product>      |
    And Customer selects canadian invoice address at the Address and delivery
    And Customer selects the Payment type
    And Customer moves forward to the Verification and order placement section
    Then Customer should see the correct tax amount displayed next to the net price in order
      |totalPrice   |federalTaxes  |provincialTaxes    |
      |<totalPrice> |<federalTaxes>|<provincialTaxes>  |

    Examples:
      | product                  |totalPrice |federalTaxes|provincialTaxes  |
      | Remote Engine Start      |$CA49.95   | $CA2.50    |   $CA4.98       |