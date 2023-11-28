package clientData;

import java.util.Random;

public class ClientDataGenerator {
    private static final String[] FIRST_NAMES = {"Irina", "Laura", "Valdis", "Daniels", "Ieva", "Uldis"};
    private static final String[] LAST_NAMES = {"Lauva", "Oga", "Perle", "Egle", "Zvaigzne", "Bruks"};

    private final Random random = new Random();

    public String generateRandomFirstName() {
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
    }

    public String generateRandomLastName() {
        return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }

    public String generateRandomEmail() {
        String firstName = generateRandomFirstName().toLowerCase();
        String lastName = generateRandomLastName().toLowerCase();
        String domain = "test.com";
        return firstName + "." + lastName + "@" + domain;
    }

    public String generateRandomPersonalID() {
        int number = 1000000 + random.nextInt(9000000);
        return Integer.toString(number);
    }
    public String generateAccountNumber() {
        int number = 1000000000 + random.nextInt(900000000);
        return Integer.toString(number);
    }
}
