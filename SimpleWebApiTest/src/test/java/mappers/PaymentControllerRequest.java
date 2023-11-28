package mappers;

public class PaymentControllerRequest {
    private String accountHolderFullName;
    private String accountHolderPersonalId;
    private String transactionType;
    private String investorId;
    private Amount amount;
    private String bookingDate;
    private String accountNumber;
    public PaymentControllerRequest() {
    }
    public PaymentControllerRequest(String accountHolderFullName, String accountHolderPersonalId, String transactionType, String investorId, Amount amount, String bookingDate, String accountNumber) {
        this.accountHolderFullName = accountHolderFullName;
        this.accountHolderPersonalId = accountHolderPersonalId;
        this.transactionType = transactionType;
        this.investorId = investorId;
        this.amount = amount;
        this.bookingDate = bookingDate;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderFullName() {
        return accountHolderFullName;
    }

    public void setAccountHolderFullName(String accountHolderFullName) {
        this.accountHolderFullName = accountHolderFullName;
    }

    public String getAccountHolderPersonalId() {
        return accountHolderPersonalId;
    }

    public void setAccountHolderPersonalId(String accountHolderPersonalId) {
        this.accountHolderPersonalId = accountHolderPersonalId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
