
import sun.reflect.generics.tree.Tree;
import java.util.*;

public class assignRobot {
    private Request request;
    private TreeSet<Robot> robots; //listado de mis cinco robts
    private HashSet <Robot> robotsAssigned; //listado de robots asignados

    public assignRobot( TreeSet<Robot> robots, HashSet<Robot> robotsAssigned) {
        this.robots = robots;
        this.robotsAssigned = robotsAssigned;
    }

    public HashSet assignationPlatinum (){

        //SIN TERMINAR (tengo que repensar el if porque no me gusta)
        
        if(request.getClient().getMembership().getType() == "Platinum"){

            Iterator<Robot> it = robots.iterator();
            Robot aux = it.next();
            Robot fewerRequestQueue = aux;

            while (it.hasNext()){
                aux = it.next();
                if(aux.getRequests().size() < fewerRequestQueue.getRequests().size()){
                    fewerRequestQueue = aux;
                }
            }
            robotsAssigned.add(fewerRequestQueue);

        }
        return robotsAssigned;
    }




    public HashSet assignationOthers() {

        ArrayList<Tasks> tareas = request.getRequestedTasks();
        Iterator<Tasks> it = tareas.iterator();

        while (it.hasNext()){
            Tasks keyTask = Tasks.valueOf(String.valueOf((it.next())));

            TreeSet<Robot> tsRobot = robots;
            Iterator<Robot> ts = tsRobot.iterator();

            boolean assigned = false;
            while (ts.hasNext() && !assigned){

                Robot keyRobot = ts.next();

                if(keyRobot.implementsInterface(keyTask)){
                    robotsAssigned.add(keyRobot);
                    assigned = true;
                }


            }

        }

        return robotsAssigned;
    }



}
