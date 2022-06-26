package Services;

import Entities.Employee;

public class Electricity extends Service{

    public Electricity(int complexity, Employee employee) {
        super(complexity, employee);
    }

    @Override
    public float setCost() {
        float value = 0;
        if (super.getComplexity() < 3){
            value = 2000;
        }
        else if (super.getComplexity() <= 6){
            value = 4573;
        }
        else {
            value = 7359;
        }

       return (float)( value + (getEmployee().getSalaryPerHour()  * getComplexity()));
    }
}
