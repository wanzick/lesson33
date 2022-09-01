import java.util.HashMap;
import java.util.Random;

public class Bank {
    private HashMap<String,Account> accounts; // id клиента и счет

    public Bank(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    private synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Thread.sleep(1000);
        return new Random().nextBoolean();
    }

    public void transfer(String fromClient, String toClient, long amount) throws InterruptedException {
        Account from = accounts.get(fromClient); // счет с которого отправляем
        Account to = accounts.get(toClient); // счет куда отправляем
        if (!from.isBlocked() && !to.isBlocked()){
            if (amount <= 50000){
                simpleTransfer(from,to,amount);
            }else {
                if(isFraud(from.getAccNumber(),to.getAccNumber(),amount)){
                    from.setBlocked(true);
                    to.setBlocked(true);
                    System.out.println("Перевод заблокирован со счета № " + from.getAccNumber()
                            + " на счет № " + to.getAccNumber());
                }else{
                    simpleTransfer(from,to,amount);
                }
            }
        }
    }

//    private long getBalance(String clientId){
//        return accounts.get(clientId).getMoney();
//    }

    private void simpleTransfer(Account from, Account to, long amount) {
        if(from.getMoney() >= amount){
            from.setMoney(from.getMoney() - amount);
            to.setMoney(to.getMoney() + amount);
            System.out.println(amount + " со счета № " + from.getAccNumber() +
                    " успешно переведена на счет " + to.getAccNumber());
        }else{
            System.out.println("Средств не достаточно для перевода");
        }
    }
}
