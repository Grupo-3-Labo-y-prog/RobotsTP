
import sun.reflect.generics.tree.Tree;
import java.util.*;

public class assignRobot {
    private Request request;
    private TreeSet<Robot> robots = new TreeSet<Robot>(new QueueRequestComparator()); //listado de mis cinco robts
    private HashSet <Robot> robotsAssigned; //listado de robots asignados

    public assignRobot( TreeSet<Robot> robots, HashSet<Robot> robotsAssigned) {
        this.robots = robots;
        this.robotsAssigned = robotsAssigned;
    }

    public HashSet assignation(Request request) {

        HashSet<Robot> capable = new HashSet<Robot>();

        if (request.getClient().getMembership().getType().equals("Platinum")) {

            return capable = capableRobots();

        } else{
            //ver si podemos pisar vector ordenado por cola de pedidos con el de costos.
             this.robots = new TreeSet<Robot>(new CostComparator());
                return capable = capableRobots();
        }
    }

        public HashSet<Robot> capableRobots() {

            ArrayList<Tasks> tareas = request.getRequestedTasks();
            Iterator<Tasks> it = tareas.iterator();

            while (it.hasNext()) {
                Tasks keyTask = Tasks.valueOf(String.valueOf((it.next())));

                TreeSet<Robot> tsRobot = robots;
                Iterator<Robot> ts = tsRobot.iterator();

                boolean assigned = false;
                while (ts.hasNext() && !assigned) {

                    Robot keyRobot = ts.next();

                    if (keyRobot.implementsInterface(keyTask)) {
                        this.robotsAssigned.add(keyRobot);
                        assigned = true;
                    }

                }

            }
            return this.robotsAssigned;
        }

}
