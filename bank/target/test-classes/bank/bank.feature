@balance-check
Feature: Feature Bank

  Background:
    Given my checking account has a balance of $500

  @deposit
  Scenario Outline: Checking Account Balance after Deposit
    Given my checking account has a balance of $<balance>
    And I have recently made a deposit of $<deposit>
    When I check my account balance
    Then I should see $<expectedBalance> as the balance
    But there is an overdraft fee of $<fee>
    And the available balance should be $<expectedAvailableBalance>
    Examples:
      | balance | deposit | expectedBalance | fee | expectedAvailableBalance |
      | 500     | 100     | 600             | 50  | 550                      |
      | 1000    | 200     | 1200            | 50  | 1150                     |
      | 300     | 500     | 800             | 30  | 770                      |

 @withdrawal
  Scenario: Checking Account Balance after Withdrawal
    And I have recently made a Withdrawal of $100
    When I check my account balance
    Then I should see $400 as the balance
    But there is an credit interest of $50
    And the available balance should be $450

   @in-sufficient-balance
  Scenario: Checking Account Balance after Withdrawal In-Sufficient Balance
    When I request to withdraw $700
    Then I should see and error
    And the available balance should be $500
