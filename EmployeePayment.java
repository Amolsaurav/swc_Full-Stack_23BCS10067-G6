class Employee {
    private Long id;
    private String name;
    private double baseSalary;
    private double bonus;

    public Employee(Long id, String name, double baseSalary,double bonus){
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public double calculateSalary(){
        return baseSalary + bonus;
    }
    public void displayDetails(){
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Bonus: $" + bonus);
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(Long id, String name, double baseSalary, double bonus){
        super(id, name, baseSalary, bonus);
        this.bonus = bonus;
    }

    public double calculateSalary(){
        return super.calculateSalary() + bonus;
    }
}

class Developer extends Employee {
    private double overtimePay;

    public Developer(Long id, String name, double baseSalary, double overtimePay){
        super(id, name, baseSalary,overtimePay);
    }

    public double calculateSalary(){
        return super.calculateSalary() + overtimePay;
    }
}

public class EmployeePayment {
    public static void main(String[] args){
        Employee manager = new Manager(1L, "Alice", 5000.0, 1800.0);
        Employee developer = new Developer(2L, "Bob", 4000.0, 1500.0);
        manager.calculateSalary();
        developer.calculateSalary();
        manager.displayDetails();
        developer.displayDetails();
    }
}
