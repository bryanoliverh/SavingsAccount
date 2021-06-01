/**
 * @author Abraham Kristanto 1806200274,
 * @author Bryan Oliver 1806200305,
 * @author Phillipus Kristian Renaldy 1806200053
 *
 * @since 2021-6-1
 */
class Deposit implements Runnable {
    /**
     * this run function is for creating deposit function with unpredictability behavior
     * In this function the program will do thread randomly and add balance from your saving
     */
    SavingsAccount savingsAccount;
    public Deposit(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            savingsAccount.deposit(15);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Withdraw implements Runnable {
    /**
     * this run function is for creating withdraw function with unpredictability behavior
     * In this function the program will do thread randomly and remove balance from your saving
     */
    SavingsAccount savingsAccount;
    public Withdraw(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            savingsAccount.withdraw(10);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    /**
     * This part is meant for initiating the threads that are going to be used in this project
     * @param args Unused
     */
    public static void main(String[] args) {
        SavingsAccount newSavingsAccount = new SavingsAccount();
        Thread t_1 = new Thread(new Deposit(newSavingsAccount));
        Thread t_2 = new Thread(new Withdraw(newSavingsAccount));

        t_1.start();
        t_2.start();
    }
}
