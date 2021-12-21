Feature: Capability to order digital services from MB connect shop

Scenario Outline: Login to order digital service from MB connect shop
Given Customer navigates to MB connect shop page
And  Customer logs into MB connect shop
When Customer adds the digital service to the shopping cart
  | product        |
  | <product>      |
And Customer selects canadian invoice address at the Address and delivery
And Customer selects the Payment type
And Customer moves forward to the Verification and order placement section
And  Customer could log out of the MB connect shop
  Examples:
    | product                           |totalPrice |federalTaxes|provincialTaxes  |
    | Remote & Navigation Services      |$CA49.95   | $CA2.50    |   $CA4.98       |
