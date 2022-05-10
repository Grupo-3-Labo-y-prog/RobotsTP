import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class AssignRobot {

        private Request request;
        private TreeSet<Robot> robots ; //listado de mis cinco robts
        private HashSet<Robot> robotsAssigned; //listado de robots asignados

        public AssignRobot(TreeSet<Robot> robots, HashSet<Robot> robotsAssigned) {
            this.robots = new TreeSet<>(new QueueRequestComparator());
            this.robots.addAll(robots);
            this.robotsAssigned = robotsAssigned;
        }

        public HashSet assignation(Request request){
            this.request = request;
            HashSet<Robot> capable = new HashSet<Robot>();

            if (request.getClient().getMembership().getType().equals("Platinum")) {
                TreeSet <Robot> robotsAux = new TreeSet<>(new QueueRequestComparator());
                robotsAux.addAll(this.robots);
                capable = capableRobots();
            }
            if (request.getClient().getMembership().getType().equals("Economic") || request.getClient().getMembership().getType().equals("Classic")) {
                TreeSet <Robot> robotsAux2 = new TreeSet<>(new CostComparator());
                robotsAux2.addAll(this.robots);

                capable = capableRobots();
            }

            return capable;
        }

        public HashSet<Robot> capableRobots() {

            ArrayList<Tasks> tareas = this.request.getRequestedTasks();
            Iterator<Tasks> it = tareas.iterator();

            while (it.hasNext()) {
                Tasks keyTask = Tasks.valueOf(String.valueOf(it.next()));

                TreeSet<Robot> tsRobot = robots;
                Iterator<Robot> ts = tsRobot.iterator();

                boolean assigned = false;
                while (ts.hasNext() && !assigned) {

                    Robot keyRobot = ts.next();

                    if (keyRobot.implementsInterface(keyTask)) {
                        this.robotsAssigned.add(keyRobot);
                        /*Robot r = this.robots.stream().findAny().filter(p -> p.getModel().equals(keyRobot.getModel())).get();
                        r.getRequests().add(this.request);*/
                        assigned = true;
                    }

                }

            }
            return this.robotsAssigned;
        }

    }


