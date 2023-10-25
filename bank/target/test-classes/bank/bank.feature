Feature: Feature Bank

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

  Scenario Outline: Checking Account Balance after Withdrawal
    Given my checking account has a balance of $<balance>
    And I have recently made a Withdrawal of $<withdrawal>
    When I check my account balance
    Then I should see $<expectedBalance> as the balance
    But there is an credit interest of $<interest>
    And the available balance should be $<expectedAvailableBalance>
    Examples:
      | balance | withdrawal | expectedBalance | interest | expectedAvailableBalance |
      | 500     | 100        | 400             | 50       | 450                      |

  Scenario Outline: Checking Account Balance after Withdrawal In-Sufficient Balance
    Given my checking account has a balance of $<balance>
    When I request to withdraw $<withdrawal>
    Then I should see and error
    And the available balance should be $<expectedAvailableBalance>
    Examples:
      | balance | withdrawal | expectedAvailableBalance |
      | 500     | 700        | 500                      |