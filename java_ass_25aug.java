//method of deposit and withdraw with runTimeException
class bankAccount {
    private int accNo;
    private String accName;
    private String openingDate;
    private String status;
    private double balance;

    public bankAccount(int accNo, String accName, String openingDate, String status, double balance) {
        this.accNo = accNo;
        this.accName = accName;
        this.openingDate = openingDate;
        this.status = status;
        this.balance = balance;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccName() {
        return accName;
    }

    public String getStatus() {
        return status;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
class InsufficientBalanceException extends RuntimeException{
    private String message = "Insufficient balance";
    public InsufficientBalanceException(String message){
        this.message = message;
    }
    public String toString(){
        return "InsufficientBalanceException:"+message;
    }
}
class Transaction extends bankAccount{
    Transaction(int accNo,String accName,String  openingDate,String status,double balance) {
        super(accNo,accName,openingDate,status,balance);
    }
    public void deposit(int Acc,double Bal)
    {
        setBalance(getBalance()+Bal);
        System.out.println("Your current account balance after credit "+getBalance());
    }
    public void withdraw(int Acc,double Bal){
        if(getBalance()>=Bal){
            setBalance(getBalance()-Bal);
            System.out.println("Your current account balance after debit "+getBalance());
        }
        else
            throw new InsufficientBalanceException("insufficient");

    }
}

public class Main {
    public static void java_ass_25aug.(String[] args) {


        Transaction t= new Transaction(101,"Sachin","2023-09-12","valid",5000);
        Transaction t2 = new Transaction(102,"Mohit","2023-08-12","valid",10000);
        t.deposit(101,8000);
        t.withdraw(101,7000);

    }
}
