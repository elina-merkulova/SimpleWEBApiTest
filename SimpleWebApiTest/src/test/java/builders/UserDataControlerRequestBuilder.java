package builders;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import mappers.UserDataControlerRequest;

public class UserDataControlerRequestBuilder {
    public static String build(String firstName, String surname, String personalId) throws JsonProcessingException {
        UserDataControlerRequest userDataControlerRequest = new UserDataControlerRequest(firstName, surname, personalId);
        return new ObjectMapper().writeValueAsString(userDataControlerRequest);
    }
}
