import java.util.Collection;

public class K311Yfu extends Robot{
    private final static String MODEL = "K311Y-fu";
    private final static String SURFACE = "Furniture";
    private  final  static boolean CAN_ORDER = false;
    private  final  static boolean CAN_SHINE = true;
    private final static int COST = 500;


    public K311Yfu() {
        super(MODEL,SURFACE,CAN_ORDER,CAN_SHINE,COST);
    }
}
