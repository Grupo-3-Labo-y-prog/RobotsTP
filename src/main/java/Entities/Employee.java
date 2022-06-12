package Entities;

public class Employee {

    private static final double SALARY = 50000;
    private static final double HOUR = 160;

    private int id;
    private double salary;

    public Employee(int id) {
        this.id = id;
        this.salary = SALARY;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public double getSalaryPerHour(){
        return this.salary/160;
    }
}
