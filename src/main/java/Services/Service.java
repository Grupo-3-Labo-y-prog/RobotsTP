package Services;

import Entities.Employee;

public abstract class Service {

    private int complexity;

    private Employee employee;
    private float cost;


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

    public float getCost() {
        return cost;
    }


}