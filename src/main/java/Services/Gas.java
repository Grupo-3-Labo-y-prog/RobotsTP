package Services;

import Entities.Employee;

public class Gas extends Service{

    public Gas(int complexity, Employee employee) {
        super(complexity, employee);
    }


    @Override
    public float setCost() {
        float value = 0;
        if (super.getComplexity() < 3){
            value = 1000;
        }
        else if (super.getComplexity() <= 6){
            value = 3530;
        }
        else {
            value = 6389;
        }
        return value;
    }


}