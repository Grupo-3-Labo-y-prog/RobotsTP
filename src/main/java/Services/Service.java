package Services;

import Entities.Employee;

public abstract class Service {

    private int complexity;

    private Employee employee;
    private float cost;
    private float price;

    public Service(int complexity, Employee employee) {
        this.complexity = complexity;
        this.employee = employee;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public abstract float setCost();

    public float setPrice() {
        return (float) (this.cost + (this.employee.getSalary() / 160) * this.complexity);
    }

    public float getCost() {
        return cost;
    }

    public float getPrice() {
        return price;
    }
}