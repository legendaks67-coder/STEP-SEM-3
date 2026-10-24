public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public String getId() {
        return id;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected: amount exceeds savings.");
        } else if (amount > 0) {
            savings -= amount;
        }
    }

    public int getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("pb.deposit(100) -> savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("pb.withdraw(30) -> savings = " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("pb.withdraw(500) -> rejected, savings stays " + pb.getSavings());
    }
}
