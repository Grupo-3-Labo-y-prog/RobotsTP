import java.util.Collection;
import java.util.LinkedHashSet;

public class K311Yfl extends Robot{
    private final static String MODEL = "K311Y-fl";
    private final static String SURFACE = "Floor";
    private final static int COST = 500;
    private final static boolean CAN_ORDER = false;



    public K311Yfl() {
        super(MODEL, SURFACE, CAN_ORDER, COST);
    }
}
