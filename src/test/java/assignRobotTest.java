import Bussiness.AssignRobot;
import Comparators.CostComparator;
import Entities.Client;
import Entities.Request;
import Memberships.Classic;
import Memberships.Platinum;
import Robots.*;
import Services.Complex;
import Services.Simple;
import Services.Tasks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class assignRobotTest {
    Client clientP;
    Client clientC;
    TreeSet <Robot> robots;
    HashSet<Robot> robotsAssigned;
    AssignRobot assignRobot;


    @BeforeEach
    void setUp(){
        this.clientP = new Client(1111, new Platinum(),0, 0);
        this.clientC = new Client(1111, new Classic(),0, 0);

        Robot K311Ya = new K311Ya();
        Robot K311Yfu = new K311Yfu();
        Robot K311Yfl = new K311Yfl();
        Robot S031RTY = new S031RTY();
        Robot P011H = new P011H();

        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        Request request = new Request(5,this.clientC, tasks, new Complex(), "Siempre viva 1234");
        Request request2 = new Request(8,this.clientP, tasks, new Complex(), "Emilio Frers 2048, Martinez");

        S031RTY.getRequests().add(request2);
        S031RTY.getRequests().add(request);
        K311Yfu.getRequests().add(request);
        K311Yfl.getRequests().add(request);
        P011H.getRequests().add(request);

        S031RTY.setCapableTasks();
        K311Yfu.setCapableTasks();
        K311Yfl.setCapableTasks();
        P011H.setCapableTasks();
        K311Ya.setCapableTasks();

        TreeSet <Robot> robots = new TreeSet<>(new CostComparator());
        robots.add(K311Yfu);
        robots.add(K311Yfl);
        robots.add(P011H);
        robots.add(S031RTY);
        robots.add(K311Ya);


        this.robots = robots;
        this.assignRobot = new AssignRobot(this.robots, new HashSet<>());

    }

    //punto 2: Un cliente Memberships.Classic, sin deuda, realiza un pedido de limpieza y ordenamiento. Se le asigna el robot
    //K311Y-fl y el robot Robots.S031RTY ya que el K311Y-a es m??s costoso.
    //(OJO! Cambiamos K311Y-fl por el K311Y-fu porque esa ser??a la opci??n mas econ??mica)
    @Test
    void assignRobotMoreEconomicToClassicClientCleanningOrdering (){
        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        tasks.add(Tasks.ORDERING);

        Robot K311Yfu = new K311Yfu();
        Robot S031RTY = new S031RTY();

        HashSet<Robot> expected = new HashSet<>();
        expected.add(K311Yfu);
        expected.add(S031RTY);

        Request request = new Request(1,this.clientC, tasks, new Simple(), "Libertador 2231, Olivos");

        assertEquals(expected,this.assignRobot.assignation(request));
    }
    
    //Punto 3. Un cliente Memberships.Classic, sin deuda, realiza un pedido de limpieza y lustrado de muebles. Se le asigna el robot K311Y-fl y el robot K311Y-fu.
    //(OJITO! Solo deber??a asignar el robot K311fu ya que puede hacer ambas tareas y es el mas econ??mico)
    @Test
     void assignRobotMoreEconomicToClassicClientCleanningPolishing (){
        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        tasks.add(Tasks.POLISHING);

        Robot K311Yfu = new K311Yfu();

        HashSet<Robot> expected = new HashSet<>();
        expected.add(K311Yfu);

        Request request = new Request(8,this.clientC, tasks, new Complex(), "Emilio Frers 2048, Martinez");

        assertEquals(expected, this.assignRobot.assignation(request));

    }

    //Punto 5: Un cliente Memberships.Platinum realiza un pedido y se le asigna el robot K311Y-a ya que no tiene pedidos.
    //(Todos los robots salvo el Robots.K311Ya fueron inicializados con pedidos en la fn SetUp)
    @Test
    void assignRobotWithoutQeueToPlatinum (){

        Robot K311Ya = new K311Ya();
        HashSet<Robot> expected = new HashSet<>();
        expected.add(K311Ya);

        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        Request request = new Request(5,this.clientP, tasks, new Complex(), "Siempre viva 1234");

        assertEquals(expected, this.assignRobot.assignation(request));

    }


    //Test Bonus 1: Un cliente Memberships.Classic sin deuda pide limpieza, ordenamiento y lustrado y se le asignan los robots Robots.K311Yfu y Robots.S031RTY
    @Test
    void assignRobotMoreEconomicToClassicCleanningOrderingPolishing (){

        Robot K311Yfu = new K311Yfu();
        Robot S031RTY = new S031RTY();
        HashSet<Robot> expected = new HashSet<>();
        expected.add(K311Yfu);
        expected.add(S031RTY);

        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        tasks.add(Tasks.ORDERING);
        tasks.add(Tasks.POLISHING);
        Request request = new Request(2,this.clientC, tasks, new Complex(), "42 Wallaby Way, Sydney");

        assertEquals(expected, this.assignRobot.assignation(request));

    }

}