package transactionData;

import java.util.Random;

public class TransactionDataGenerator {
    private final Random random = new Random();
    public String generateInvestorId() {
        int number = 1000 + random.nextInt(9000);
        return Integer.toString(number);
    }
}
