import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class assignRobotTest {
    Client client;
    TreeSet <Robot> robots;
    HashSet<Robot> robotsAssigned;
    AssignRobot aasignRobot;

    //punto 2 Un cliente Classic, sin deuda, realiza un pedido de limpieza y ordenamiento. Se le asigna el robot
    //K311Y-fl y el robot S031RTY ya que el K311Y-a es más costoso. (OJO! Cambiamos K311Y-fl por el K311Y-fu porque esa será la opcion mas economica)
    @BeforeEach
    void setUp(){
        this.client = new Client(1111, new Classic(),0, 0);

        Robot K311Ya = new K311Ya();
        Robot K311Yfu = new K311Yfu();
        Robot K311Yfl = new K311Yfl();
        Robot S031RTY = new S031RTY();
        Robot P011H = new P011H();
        TreeSet <Robot> robots = new TreeSet<>(new CostComparator());

        //los inserto en orden de mas barato a mas caro
        robots.add(K311Yfu);
        robots.add(K311Yfl);
        robots.add(P011H);
        robots.add(S031RTY);
        robots.add(K311Ya);

        this.robots = robots;
        this.aasignRobot = new AssignRobot(this.robots, new HashSet<>());

    }


    @Test
    void assignRobot (){
        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        tasks.add(Tasks.ORDERING);

        Robot K311Yfu = new K311Yfu();
        Robot S031RTY = new S031RTY();

        HashSet<Robot> expected = new HashSet<>();
        expected.add(K311Yfu);
        expected.add(S031RTY);

        Request request = new Request(1,this.client, tasks, new Simple(), "Libertador 2231, Olivos");


        assertTrue(this.aasignRobot.assignation(request).contains(K311Yfu));
    }
}