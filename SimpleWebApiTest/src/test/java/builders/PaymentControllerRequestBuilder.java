package builders;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import mappers.Amount;
import mappers.PaymentControllerRequest;


public class PaymentControllerRequestBuilder {
    public static String build(String accountHolderFullName, String accountHolderPersonalId, String transactionType, String investorId, String accountNumber, String bookingDate, Amount amount) throws JsonProcessingException {
        PaymentControllerRequest paymentControllerRequest = new PaymentControllerRequest(accountHolderFullName, accountHolderPersonalId, transactionType, investorId, amount, bookingDate, accountNumber);
        return new ObjectMapper().writeValueAsString(paymentControllerRequest);
    }
}

