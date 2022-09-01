import java.util.HashMap;

public class Main {
    private static final int COUNT_CLIENT = 100;
    private static final int MAX_SUMMA_FOR_TRANSFER = 100_000;

    public static void main(String[] args){
        HashMap<String,Account> accounts = new HashMap<String, Account>();
        for (var i = 1; i <= COUNT_CLIENT; i++){
            accounts.put(String.valueOf(i),new Account((long)(Math.random()*99000 + 1000),String.valueOf(i)));
        }
        Bank bank = new Bank(accounts);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (var i = 0; i < 10; i++){
                    String from = String.valueOf(Math.random() * (COUNT_CLIENT - 1) + 1);
                    String to = String.valueOf(Math.random() * (COUNT_CLIENT - 1) + 1);
                    if (!from.equalsIgnoreCase(to)){
                        try {
                            bank.transfer(from,to, (long) (Math.random() * MAX_SUMMA_FOR_TRANSFER));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

    }
}
