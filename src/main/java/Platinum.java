public class Platinum extends Membership{
    private final static int MAX_ORDER = 9999;
    private final static int MAX_CLEAN = 9999;
    private final static int LIMIT_DEBT = 1;//1 cuota
    private final static String TYPE = "Platinum";
    private final static boolean CAN_ORDER = true;

    public Platinum() {
        super(TYPE, LIMIT_DEBT, MAX_ORDER, MAX_CLEAN, CAN_ORDER);
    }
}
