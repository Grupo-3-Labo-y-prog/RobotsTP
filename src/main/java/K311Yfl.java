import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

public class K311Yfl extends Robot{
    private final static String MODEL = "K311Y-fl";
    private final static String SURFACE = "Floor";
    private final static boolean CAN_ORDER = false;
    private  final  static boolean CAN_SHINE = false;
    private final static int COST = 1000;


    public K311Yfl() {
        super(MODEL, SURFACE, CAN_ORDER,CAN_SHINE, COST);
    }
}
