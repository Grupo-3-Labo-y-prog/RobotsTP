
import java.util.*;

public class AssignRobot {
    private Request request;
    private TreeSet<Robot> robots = new TreeSet<Robot>(new QueueRequestComparator()); //listado de mis cinco robts
    private HashSet <Robot> robotsAssigned; //listado de robots asignados

    public AssignRobot(TreeSet<Robot> robots, HashSet<Robot> robotsAssigned) {
        this.robots = robots;
        this.robotsAssigned = robotsAssigned;
    }

    public HashSet assignation(Request request) throws MembershipDoesntExistException {

        HashSet<Robot> capable = new HashSet<Robot>();
        if (request.getClient().getMembership().getType().equals("Platinum")) {
            return capable = capableRobots();
        }
        if (request.getClient().getMembership().getType().equals("Economic") || request.getClient().getMembership().getType().equals("Classic")) {

            this.robots = new TreeSet<Robot>(new CostComparator());
            return capable = capableRobots();
        }
        else throw new MembershipDoesntExistException("membership does not exist");

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

                    final Robot keyRobot = ts.next();

                    if (keyRobot.implementsInterface(keyTask)) {
                        this.robotsAssigned.add(keyRobot);
                        Robot r = this.robots.stream().findAny().filter(p -> p.getModel() == keyRobot.getModel()).get();
                        r.getRequests().add(this.request);
                        assigned = true;
                    }

                }

            }
            return this.robotsAssigned;
        }

}
