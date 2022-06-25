package Services;

import Bussiness.AssignRobot;
import Robots.Robot;

import java.util.ArrayList;
import java.util.Iterator;

public class Simple implements TypeClean {

    @Override
    public float getCost() {
        float sum = (float) 0.0;
        ArrayList<Robot> robots = new ArrayList<>();
        Iterator iterator = robots.iterator();
        while (iterator.hasNext()) {
            Robot robot = (Robot) iterator.next();
            sum += robot.getCost();
        }
        return sum ;
    }
}
