import java.util.Comparator;

public class QueueRequestComparator implements Comparator<Robot> {

    public int compare(Robot robot1, Robot robot2) {

        if(robot1.getRequests().size() < robot2.getRequests().size() ){
            return 1;
        }
        if( robot1.getRequests().size() > robot2.getRequests().size() ) {
            return -1;
        }
        return 0;
    }
}