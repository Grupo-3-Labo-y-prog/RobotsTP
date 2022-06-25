package Services;

import Robots.Robot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class Complex implements TypeClean {
    @Override
    public float getCost() {
        Random claseRandom = new Random();
        int randomInt = claseRandom.nextInt(2, 5);
        float sum = (float) 0.0;
        ArrayList<Robot> robots = new ArrayList<>();
        Iterator iterator = robots.iterator();
        while (iterator.hasNext()) {
            Robot robot = (Robot) iterator.next();
            sum += robot.getCost() * randomInt;
            randomInt = claseRandom.nextInt(2, 5);
        }
        return sum ;
    }
}
