package clientData;

public class Client {
    ClientDataGenerator clientDataGenerator = new ClientDataGenerator();
    String name = clientDataGenerator.generateRandomFirstName();
    String surname = clientDataGenerator.generateRandomLastName();
    String email = clientDataGenerator.generateRandomEmail();
    String personalId = clientDataGenerator.generateRandomPersonalID();
    String accountNumber = clientDataGenerator.generateAccountNumber();

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }
}
