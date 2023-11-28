package mappers;

public class UserDataControlerRequest {
    private String firstName;
    private String surname;
    private String personalId;
    public UserDataControlerRequest() {
    }
    public UserDataControlerRequest(String firstName, String surname, String personalId) {
        this.firstName = firstName;
        this.surname = surname;
        this.personalId = personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }
}
