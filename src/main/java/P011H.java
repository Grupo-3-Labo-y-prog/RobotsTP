import java.util.Collection;

public class P011H extends Robot {

    private final static String MODEL = "P011H";
    private final static String SURFACE = "Floor";
    private  final  static boolean CAN_ORDER = false;
    private  final  static boolean CAN_SHINE = true;
    private final static int COST = 1500;



    public P011H() {
        super(MODEL, SURFACE,CAN_ORDER,CAN_SHINE, COST);
    }

}
