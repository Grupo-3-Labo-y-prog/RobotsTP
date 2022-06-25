package Services;

import Robots.Robot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class Complex implements TypeClean {
    @Override
    public float getCost() {
        int randomInt = (int)(Math.random()*5+2);
        float sum = (float) 0.0;
        ArrayList<Robot> robots = new ArrayList<>();
        Iterator iterator = robots.iterator();
        while (iterator.hasNext()) {
            Robot robot = (Robot) iterator.next();
            sum += robot.getCost() * randomInt;
            randomInt = (int)(Math.random()*5+2);
        }
        return sum ;
    }
}
