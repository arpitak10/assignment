//Deque using employee class
import java.util.ArrayDeque;
import java.util.Deque;

class Emp{
    private int empid;
    private String empName;
    private int salary;
    Emp(){}
    Emp(int empid,String empName,int salary){
        this.empid = empid;
        this.empName = empName;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public int getEmpid() {
        return empid;
    }

    public String getEmpName() {
        return empName;
    }
    public String toString(){
        return empid+" "+empName+" "+salary;
    }
}
public class java_ass_24aug.s {
    public static void main(String[] args) {
        Deque<Emp> deque = new ArrayDeque<>();
        deque.offer(new Emp(101,"Rama",3000));
        deque.offer(new Emp(102,"Rohan",4000));
        System.out.println(deque);
    }
}
//hashmap of emailId and password 

public class Main {
    public static void ava_ass_24aug(String[] args) {
        HashMap<String ,String >emailAccountMap = new HashMap<>();
        emailAccountMap.put("Ajay@gmail.com", "Ajay@123");
        emailAccountMap.put("Anay@gmail.com", "Anay@123");
        emailAccountMap.put("Raj@gmail.com", "Raj@123");
        emailAccountMap.put("Sohan@gmail.com", "Sohan@123");
        System.out.println(emailAccountMap);

    }
}
//hashmap of employee and address
class Address{
    private  String hno;
    private String street;
    private String city;
    private String state;
    public  Address(){}
    public Address(String hno,String street,String city,String state){
        this.hno = hno;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public String getHno() {
        return hno;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }
    public String toString(){
        return hno+" "+street+" "+city+" "+state;
    }
}
class Employee{
    private  int empid;
    private String empname;
    private int salary;
    private  int deptno;
    Employee(){};
    Employee(int empid,String empname,int salary,int deptno){
        this.empid = empid;
        this.empname = empname;
        this.salary = salary;
        this.deptno = deptno;

    }

    public int getDeptno() {
        return deptno;
    }

    public int getEmpid() {
        return empid;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmpname() {
        return empname;
    }
    public String toString(){
        return  empid+" "+empname+" "+salary+" "+deptno;
    }
}
public  class Main {
    public static void java_ass_24aug(String[] args) {
        HashMap<Employee,Address>map = new HashMap<>();
        map.put(new Employee(101,"aJAY",1000,10),new Address("123","roop","blr","KN"));
        map.put(new Employee(102,"JAY",2000,10),new Address("124","roop","blr","KN"));
        Set<Map.Entry<Employee,Address>> entrySet = map.entrySet();
        for (Map.Entry<Employee,Address> e:entrySet){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println();
        }
        System.out.println(entrySet);

    }
}
