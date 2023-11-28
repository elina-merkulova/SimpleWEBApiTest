package Requesters;

import builders.PaymentControllerRequestBuilder;
import builders.SignUpRequestBuilder;
import builders.UserDataControlerRequestBuilder;
import clientData.Client;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import mappers.Amount;
import mappers.Payment;
import org.hamcrest.Matchers;
import transactionData.TransactionData;


import java.util.List;

public class Requesters {
    private final Client client = new Client();
    private final TransactionData transactionData = new TransactionData();
    private final String baseUrl = "http://localhost:8080";

    private Response postProtectedAPI(String endpoint, String body, Integer userId) {
        return RestAssured.given()
                .log().all()
                .auth().basic(String.valueOf(userId), "")
                .accept("/*/")
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    private Response postRequest(String endpoint, String body) {
        return RestAssured.given()
                .log().all()
                .accept("*/*")
                .contentType("application/json")
                .body(body)
                .when()
                .log().all()
                .post(endpoint);
    }

    private Response getRequest(String endpoint, Integer userId) {
        return RestAssured.given()
                .log().all()
                .auth().basic(String.valueOf(userId), "")
                .contentType("application/json")
                .when()
                .get(endpoint);
    }

    public Integer registerClient() throws JsonProcessingException {
        String endpoint = baseUrl + "/public/sign-up";
        String body = SignUpRequestBuilder.build(client.getEmail(), "password");

        Response response = postRequest(endpoint, body);
        response.then().statusCode(200)
                .body("message.status", Matchers.equalTo("SUCCESS"))
                .body("message.message", Matchers.equalTo("User registered"));
        return response.then().extract().path("user.id");
    }

    public void alterClientData(Integer userId) throws JsonProcessingException {
        String endpoint = baseUrl + "/api/personal-data";
        String body = UserDataControlerRequestBuilder.build(client.getName(), client.getSurname(), client.getPersonalId());

        Response response = postProtectedAPI(endpoint, body, userId);
        System.out.println(response.body().asString());
        response.then().statusCode(201)
                .body("message.status", Matchers.equalTo("SUCCESS"))
                .body("message.message", Matchers.equalTo("Personal info updated"));
    }

    public void addTransaction(String currency, Double transactionAmount, String transactionType, String bookingDate) throws JsonProcessingException {
        String endpoint = baseUrl + "/api/add-funds";
        Amount amount = new Amount(currency, transactionAmount);
        String body = PaymentControllerRequestBuilder.build(client.getName() + " " + client.getSurname(), client.getPersonalId(), transactionType, transactionData.getInvestorId(), client.getAccountNumber(), bookingDate, amount);

        Response response = postRequest(endpoint, body);

        response.then().statusCode(200);
    }

    public Double getBalance(Integer userId) {
        String endpoint = baseUrl + "/api/balance";
        Response response = getRequest(endpoint, userId);
        String balanceAsString = response.toString();
        return Double.parseDouble(balanceAsString);
    }

    public List<Payment> getPayments(Integer userId) throws JsonProcessingException {
        String endpoint = baseUrl + "/api/payments";
        Response response = getRequest(endpoint,userId);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.asString(), new TypeReference<List<Payment>>() {
        });
    }
}

