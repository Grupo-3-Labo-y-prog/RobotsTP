import java.util.ArrayList;

public class Admission {

    private ArrayList<Request> approvedRequests;
    private ArrayList<Request> rejectRequests;
    private Payment payment;

    public void validMembership(Request request) throws CantOrderingException, LimitException {

        Membership membership = request.getClient().getMembership();

        this.canOrdering(request, membership);
        this.limitOfCleaning(request);
        this.limitOfOrdering(request);

        this.approvedRequests.add(request);

    }

    public void validDebt(Request request) throws LimitException {

        this.limitDebt(request);

        this.approvedRequests.add(request);
    }

    private void canOrdering(Request request, Membership membership) throws CantOrderingException {

        boolean askOrdering = request.getRequestedTasks().contains(Tasks.ORDERING);
        if (askOrdering) {
            if (askOrdering != membership.isCanOrder()) {
                this.addRejected(request);
                throw new CantOrderingException("membership owned does not include ordering");

            }
        }

    }

    private void limitOfCleaning(Request request) throws LimitException {
        if (request.getClient().getCleaning() >= request.getClient().getMembership().getLimitClean()){
            this.addRejected(request);
            throw new LimitException("cleaning limit reached");
        }
    }

    private void limitOfOrdering(Request request) throws LimitException {
        if (request.getClient().getOrdering() >= request.getClient().getMembership().getLimitOrder()){
            this.addRejected(request);
            throw new LimitException("order limit reached");
        }
    }

    private void limitDebt(Request request) throws LimitException {
        if (this.payment.getAmount(request.getClient().id) > request.getClient().getMembership().getLimitDebt()){
            this.addRejected(request);
            throw new LimitException("the limit of the debt has been reached");
        }
    }

    public ArrayList<Request> getApprovedRequests() {
        return approvedRequests;
    }

    public void setApprovedRequests(ArrayList<Request> approvedRequests) {
        this.approvedRequests = approvedRequests;
    }

    public ArrayList<Request> getRejectRequests() {
        return rejectRequests;
    }

    public void setRejectRequests(ArrayList<Request> rejectRequests) {
        this.rejectRequests = rejectRequests;
    }

    public Admission(ArrayList<Request> approvedRequests, ArrayList<Request> rejectRequests, Payment payment) {
        this.approvedRequests = approvedRequests;
        this.rejectRequests = rejectRequests;
        this.payment = payment;
    }

    private void addRejected(Request request){
        this.rejectRequests.add(request);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
