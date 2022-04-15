public class Membership {
    private String type;
    private int limitDebt;
    private int limitOrder;
    private int limitClean;
    private boolean canOrder;

    public Membership(String type, int limitDebt, int limitOrder, int limitClean, boolean canOrder) {
        this.type = type;
        this.limitDebt = limitDebt;
        this.limitOrder = limitOrder;
        this.limitClean = limitClean;
        this.canOrder = canOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLimitDebt() {
        return limitDebt;
    }

    public void setLimitDebt(int limitDebt) {
        this.limitDebt = limitDebt;
    }

    public int getLimitOrder() {
        return limitOrder;
    }

    public void setLimitOrder(int limitOrder) {
        this.limitOrder = limitOrder;
    }

    public int getLimitClean() {
        return limitClean;
    }

    public void setLimitClean(int limitClean) {
        this.limitClean = limitClean;
    }

    public boolean isCanOrder() {
        return canOrder;
    }

    public void setCanOrder(boolean canOrder) {
        this.canOrder = canOrder;
    }
}
