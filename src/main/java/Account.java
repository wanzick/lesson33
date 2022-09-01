public class Account {
    private long money;
    private String accNumber;
    private boolean isBlocked;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    /**
     * Проверка баланса на счете
     * @return
     */
    public long getMoney(){
        if (!isBlocked){
            return money;
        }else{
            System.out.println("Счет " + accNumber + " заблокирован!");
            return 0;
        }
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlocked(){
        return isBlocked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + getMoney() +
                ", accNumber='" + accNumber +
                '}';
    }
}
