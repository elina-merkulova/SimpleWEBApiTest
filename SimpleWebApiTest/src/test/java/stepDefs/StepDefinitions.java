package stepDefs;

import Requesters.Requesters;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mappers.Payment;
import org.junit.jupiter.api.Assertions;
import utils.DateTimeOperations;

import java.util.List;
import java.util.Map;


public class StepDefinitions {
    private Integer userId;
    Requesters requesters = new Requesters();
    DateTimeOperations date = new DateTimeOperations();

    @Given("client is registered")
    public void register_client() throws JsonProcessingException {
        userId = requesters.registerClient();
        requesters.alterClientData(userId);
    }

    @When("client adds {double} amount and {string} currency")
    public void add_funds(Double amount, String currency) throws JsonProcessingException {
        requesters.addTransaction(currency, amount, "FUNDING", date.getCurrentDate());
    }

    @Then("balance is {double}")
    public void check_balance(Double expectedBalance) {
        Assertions.assertEquals(expectedBalance, requesters.getBalance(userId), "Actual client balance doesn't match");
    }

    @Then("transactions are:")
    public void check_transactions(Map<String, String> params) throws JsonProcessingException {
        List<Payment> payments = requesters.getPayments(userId);
        String actualType = payments.get(0).getType();
        Assertions.assertEquals(params.get("type"), actualType, "Type of transaction doesn't match actual type");
        String actualAmount = payments.get(0).getAmount().toString();
        Assertions.assertEquals(params.get("amount"), actualAmount, "Amount of transaction doesn't match actual amount");
    }
}
