package Bussiness;

import Comparators.CostComparator;
import Comparators.QueueRequestComparator;
import Entities.Request;
import Robots.Robot;
import Services.Tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class AssignRobot {

        private Request request;
        private ArrayList<Robot> robots ; //listado de mis cinco robts
        private HashSet<Robot> robotsAssigned; //listado de robots asignados

        public AssignRobot(TreeSet<Robot> robots, HashSet<Robot> robotsAssigned) {
            this.robots = new ArrayList<>();
            this.robots.addAll(robots);
            this.robotsAssigned = robotsAssigned;
        }

        public HashSet assignation(Request request){
            this.request = request;
            HashSet<Robot> capable = new HashSet<Robot>();

            if (request.getClient().getMembership().getType().equals("Memberships.Platinum")) {
                TreeSet <Robot> robotsAux = new TreeSet<>(new QueueRequestComparator());
                robotsAux.addAll(this.robots);
                capable = capableRobots(robotsAux);
            }
            if (request.getClient().getMembership().getType().equals("Memberships.Economic") || request.getClient().getMembership().getType().equals("Memberships.Classic")) {
                TreeSet <Robot> robotsAux2 = new TreeSet<>(new CostComparator());
                robotsAux2.addAll(this.robots);

                capable = capableRobots(robotsAux2);
            }

            return capable;
        }

        public HashSet<Robot> capableRobots(TreeSet<Robot> robotsAux) {

            ArrayList<Tasks> tareas = this.request.getRequestedTasks();
            Iterator<Tasks> it = tareas.iterator();

            while (it.hasNext()) {
                Tasks keyTask = Tasks.valueOf(String.valueOf(it.next()));

                Iterator<Robot> ts = robotsAux.iterator();

                boolean assigned = false;
                while (ts.hasNext() && !assigned) {

                    Robot keyRobot = ts.next();

                    if (keyRobot.implementsInterface(keyTask)) {
                        this.robotsAssigned.add(keyRobot);

                        int index = this.robots.indexOf(keyRobot);

                        this.robots.get(index).getRequests().add(this.request);

                        assigned = true;
                    }

                }

            }
            return this.robotsAssigned;
        }


    }


