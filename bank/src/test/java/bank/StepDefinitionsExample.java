package bank;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitionsExample {
    private int accountNumber;
    private double balance;


    @Given("a user with account number {int}")
    public void a_user_with_account_number(Integer int1) {
        // information additional for setting up the user
        this.accountNumber = accountNumber;
    }
    @When("they check their balance")
    public void they_check_their_balance() {
        // Write code here that turns the phrase above into concrete actions
       this.balance = retrieveBalance(accountNumber);
    }
    @Then("they should see a balance of a ${double}")
    public void they_should_see_a_balance_of_a_$(double expectedResult) {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(expectedResult, balance);
    }
    private double retrieveBalance(int accountNumber) {
        //Code to retrieve the balance from the system/dataBase
        //replace with your actual implementation
        return 10100;
    }
}
