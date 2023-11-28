package builders;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import mappers.SignUpRequest;

public class SignUpRequestBuilder {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String build (String email, String password) throws JsonProcessingException {
        SignUpRequest signUpRequest = new SignUpRequest(email, password);
        return objectMapper.writeValueAsString(signUpRequest);
    }
}
