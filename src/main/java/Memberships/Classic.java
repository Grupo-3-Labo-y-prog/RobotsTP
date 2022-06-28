package Memberships;

public class Classic extends Membership{
    private final static int MAX_ORDER = 3;
    private final static int MAX_CLEAN = 99999;
    private final static int LIMIT_DEBT = 1;
    private final static String TYPE = "Memberships.Classic";
    private final static boolean CAN_ORDER = true;

    public Classic() {
        super(TYPE, LIMIT_DEBT, MAX_ORDER, MAX_CLEAN, CAN_ORDER);
    }
}
