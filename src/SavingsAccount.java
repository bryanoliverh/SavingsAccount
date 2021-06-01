/**
 * @author Abraham Kristanto 1806200274,
 * @author Bryan Oliver 1806200305,
 * @author Phillipus Kristian Renaldy 1806200053
 *
 * @since 2021-6-1
 */

public class SavingsAccount {
    public float balance;

    /**
     * function for withdrawing balance
     * if the amount is negative, an exception will be thrown
     * use synchronized function
     */
    public void withdraw(float anAmount) {
        if (anAmount < 0.0) {
            throw new IllegalArgumentException("Withdraw amount negative");
        }

        synchronized (this) {
            if (anAmount <= balance) {
                balance = balance - anAmount;
                String threadName = Thread.currentThread().getName();
                System.out.println("Balance after withdraw by " + threadName + " : " + balance);
            }
        }
    }

    /**
     * function for deposit balance
     * if the amount is negative, an exception will be thrown
     * use synchronized function
     */
    public void deposit(float anAmount) {
        if (anAmount < 0.0) {
            throw new IllegalArgumentException("Deposit amount negative");
        }
        synchronized (this) {
            balance = balance + anAmount;
            String threadName = Thread.currentThread().getName();
            System.out.println("Balance after deposit by " + threadName + " : " + balance);
        }
    }
}