public class Economic extends Membership{
    private final static int MAX_ORDER = 0;
    private final static int MAX_CLEAN = 3;
    private final static int LIMIT_DEBT = 1;
    private final static String TYPE = "Economic";
    private final static boolean CAN_ORDER = false;

    public Economic() {
        super(TYPE, LIMIT_DEBT, MAX_ORDER, MAX_CLEAN, CAN_ORDER);
    }
}
