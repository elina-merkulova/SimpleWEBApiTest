Feature: End to End test

  Scenario: Client can register and update balance
    Given client is registered
    When client adds 3.2 amount and "EUR" currency
    Then balance is 3.2
    And transactions are:
      | type   | FUNDING |
      | amount | 3.2     |
