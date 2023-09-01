//exexcting reaadThread and modifyThread together. But when modifyThread is modifyng then ReadThread does not read the object.
class Account{
    private int accNo;
    private double balance;
    public  Account(){}
    public Account(int accNo,double balance){
        this.accNo = accNo;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }
}
class Transaction{
    Semaphore findBalance = new Semaphore(0);
    Semaphore modifyBalance = new Semaphore(1);
    public  void transact(Account acc, double amt,char ttype){
        try{
            modifyBalance.acquire();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        if (ttype == 'D' || ttype == 'd')
            acc.setBalance(acc.getBalance()+amt);
        else if (ttype == 'W' || ttype =='w') {
            acc.setBalance(acc.getBalance()-amt);
        }
        findBalance.release();

    }
    public void checkBalance(Account acc){
        try {
            findBalance.acquire();
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        System.out.println(acc.getBalance());
        modifyBalance.release();
    }


}
class ModifyBalanceThread implements Runnable{
    Account acc;
    double amt;
    Thread t;
    Transaction transaction;
    public ModifyBalanceThread(Account acc,Transaction transaction,double amt){
        this.acc = acc;
        this.transaction  = transaction;
        this.amt = amt;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        transaction.transact(acc,amt,'D');
        System.out.println(acc.getAccNo()+" Balance is M O D I F I E D"+acc.getBalance());
    }
}
class FindBalanceThread implements Runnable{
    Account acc;
    Thread t;
    Transaction transaction;
    public FindBalanceThread(Account acc,Transaction transaction){
        this.acc = acc;
        this.transaction  = transaction;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        transaction.checkBalance(acc);
        System.out.println(acc.getBalance()+" R E A D");
    }
}
public class Main {
    public static void main(String[] args) {
        Account acc1 = new Account(5001,9000);
        Transaction trans1 = new Transaction();
        FindBalanceThread fbt = new FindBalanceThread(acc1,trans1);
        ModifyBalanceThread mbt = new ModifyBalanceThread(acc1,trans1,1000);
        try {
            fbt.t.join();
            mbt.t.join();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
//DAO assignment
package org.example.DAO;

import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        Company c = new Company();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while (true){
            System.out.println("1. Add Employee details");
            System.out.println("2. Display all Employee Details");
            System.out.println("3. Display Employee Details by employee id");
            System.out.println("4. Modify Employee Details by employee id");
            System.out.println("5. Delete Employee Details by employee id");
            System.out.println("6. Exit");
            int key = sc.nextInt();
            switch (key){
                case 1:

                    System.out.println("Enter employee id");
                    int empid = sc.nextInt();
                    System.out.println("Enter employee name");
                    String ename = sc.next();
                    System.out.println("Enter employee salary");
                    double salary = sc.nextDouble();
                    System.out.println("Enter employee department");
                    String departmentName = sc.next();
                    System.out.println("Enter employee manager");
                    String managerName = sc.next();
                    Employee e = new Employee(empid,ename,salary,departmentName,managerName);
                    c.addEmployeeDetails(e);
                    break;
                case 2:
                    c.displayAllEmployeeDetails();
                    break;
                case 3:
                    c.displayEmployeeDetailsById(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Enter employee id");
                    empid = sc.nextInt();
                    System.out.println("Enter employee salary");
                    salary = sc.nextDouble();
                    System.out.println("Enter employee department");
                    departmentName = sc.next();
                    System.out.println("Enter employee manager");
                    managerName=sc.next();
                    Employee e1 = new Employee(empid,"",salary,departmentName,managerName);
                    c.modifyEmployeeDetails(e1);
                    break;
                case 5:
                    System.out.println("Enter employee id");
                    c.deleteEmployeeDetails(sc.nextInt());
                    break;
                default:
                    flag = true;

            }
            if(flag==true)
                break;
        }
 

    }
}
package org.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDAO {
    private static String url = "jdbc:mysql://localhost:3306/gain";

    public Employee getEmployeeByEmployeeId(int empid) {
        Employee emp = null;
        try (Connection con = DriverManager.getConnection(url, "root", "Arpitak@10");
             PreparedStatement pst = con.prepareStatement("select * from employee where emp_no = ?")) {
            pst.setInt(1,empid);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                emp = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return emp;

    }

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> elist = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, "root", "Arpitak@10");
             PreparedStatement pst = con.prepareStatement("select * from employee ")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next())
                elist.add(new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return elist;

    }

    public boolean addEmployee(Employee emp) {
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "Arpitak@10");
             PreparedStatement pst = con.prepareStatement("insert into employee values (?,?,?,?,?)")) {
            pst.setInt(1, emp.getEmpid());
            pst.setString(2, emp.getEname());
            pst.setDouble(3, emp.getSalary());
            pst.setString(4, emp.getDepartmentName());
            pst.setString(5, emp.getManagerName());
            count = pst.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count == 1;

    }

    public boolean modifyEmployee(Employee emp) {
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "Arpitak@10");
             PreparedStatement pst = con.prepareStatement("update employee set emp_sal = ? , department = ? ,manager_name = ? where emp_no = ? ")) {
            pst.setDouble(1, emp.getSalary());
            pst.setString(2, emp.getDepartmentName());
            pst.setString(3, emp.getManagerName());
            pst.setInt(4, emp.getEmpid());


            count = pst.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count == 1;
    }
    public boolean deleteEmployeeByEmployeeId(int empid) {
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "Arpitak@10");
             PreparedStatement pst = con.prepareStatement("delete from employee where emp_no = ?")) {
           pst.setInt(1,empid);
           count = pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return count == 1;
    }
}
