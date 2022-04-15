public class K311Ya extends Robot{

    private final static String MODEL = "K311Ya";
    private final static String SURFACE = "Floor/Furniture";
    private  final  static boolean CAN_ORDER = true;
    private  final  static boolean CAN_SHINE = true;
    private final static int COST = 5000;

    public K311Ya() {
        super(MODEL,SURFACE,CAN_ORDER,CAN_SHINE,COST);
    }
}
