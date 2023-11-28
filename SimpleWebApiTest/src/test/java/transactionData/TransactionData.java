package transactionData;

public class TransactionData {
    TransactionDataGenerator transactionDataGenerator = new TransactionDataGenerator();
    private String investorId = transactionDataGenerator.generateInvestorId();

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }
}
