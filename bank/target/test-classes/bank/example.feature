Feature: An example

  Scenario: Check balance for a valid account
    Given a user with account number 12345678
    When they check their balance
    Then they should see a balance of a $10100.00