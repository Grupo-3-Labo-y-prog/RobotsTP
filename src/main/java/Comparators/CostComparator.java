package Comparators;

import Robots.Robot;

import java.util.Comparator;

public class CostComparator implements Comparator<Robot> {

    public int compare(Robot robot1, Robot robot2) {

        if( robot1.getCost() < robot2.getCost() ){
            return -1;
        }
        if( robot1.getCost() > robot2.getCost() ) {
            return 1;
        }
        return 0;
    }
}