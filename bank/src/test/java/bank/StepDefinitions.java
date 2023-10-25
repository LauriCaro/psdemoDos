package bank;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private int accountNumber;
    private int balance;


//    @Given("a user with account number {int}")
//    public void a_user_with_account_number(Integer int1) {
//        // information additional for setting up the user
//        this.accountNumber = accountNumber;
//    }
//    @When("they check their balance")
//    public void they_check_their_balance() {
//        // Write code here that turns the phrase above into concrete actions
//       this.balance = retrieveBalance(accountNumber);
//    }
//    @Then("they should see a balance of a ${double}")
//    public void they_should_see_a_balance_of_a_$(double expectedResult) {
//        // Write code here that turns the phrase above into concrete actions
//        Assertions.assertEquals(expectedResult, balance);
//    }
//
//
//    private double retrieveBalance(int accountNumber) {
//        //Code to retrieve the balance from the system/dataBase
//        //replace with your actual implementation
//        return 10100;
//    }
    private int balanceCurrent;
    private int depositCurrent;
    private int actualBalance;
    private int balanceAfterOverDraft;
    private int overDraftFee;
    private int interestActual;
    private int withdrawalActual;

    @Given("my checking account has a balance of ${int}")
    public void my_checking_account_has_a_balance_of_$(Integer balance) {
        this.balanceCurrent = balance;
    }

    @And("I have recently made a deposit of ${int}")
    public void i_have_recently_made_a_deposit_of_$(Integer deposit) {
        this.depositCurrent = deposit;
    }
    @When("I check my account balance")
    public void i_check_my_account_balance() {
        actualBalance = balanceCurrent + depositCurrent - withdrawalActual;
    }
    @Then("I should see ${int} as the balance")
    public void i_should_see_as_the_balance(Integer expectedBalance) {
        assertEquals(expectedBalance, actualBalance);
    }
    @Then("there is an overdraft fee of ${int}")
    public void there_is_an_overdraft_fee_of_$(Integer fee) {
        overDraftFee = fee;
    }
    @Then("the available balance should be ${int}")
    public void the_available_balance_should_be_$(Integer expectedAvailableBalance) {
        if(withdrawalActual>0 && withdrawalActual > balanceCurrent + depositCurrent - overDraftFee + interestActual ){
            balanceAfterOverDraft = balanceCurrent + depositCurrent - overDraftFee + interestActual;
        }else {
            balanceAfterOverDraft = balanceCurrent + depositCurrent - withdrawalActual - overDraftFee + interestActual;
        }

        assertEquals(expectedAvailableBalance, balanceAfterOverDraft);
    }


    @And("I have recently made a Withdrawal of ${int}")
    public void iHaveRecentlyMadeAWithdrawalOf$(int withdrawal) {
        this.withdrawalActual = withdrawal;
    }

    @But("there is an credit interest of ${int}")
    public void thereIsAnCreditInterestOf$(int interest) {
        this.interestActual = interest;
    }

    @When("I request to withdraw ${int}")
    public void iRequestToWithdraw$(int withdrawal) {
        this.withdrawalActual = withdrawal;
    }

    @Then("I should see and error")
    public void iShouldSeeAndError() {
        String errorMessage = ">> Error: The withdrawal is not allowed due to insufficient found. <<";
        System.out.println(errorMessage);
    }
}
