import java.util.ArrayList;

public class Admission {

    private ArrayList<Request> approvedRequests;
    private ArrayList<Request> rejectRequests;
    private Payment payment;

    public void validMembership(Request request) {

        Membership membership = request.getClient().getMembership();
        Client client = request.getClient();

        try {
            this.canOrdering(request, membership);
            this.limitOfCleaning(client, membership);
            this.limitOfOrdering(client, membership);
        } catch (CantOrderingException e) {
            this.rejectRequests.add(request);
            e.printStackTrace();
        } catch (LimitException e) {
            this.rejectRequests.add(request);
            e.printStackTrace();
        }

        this.approvedRequests.add(request);

    }

    public void validDebt(Request request){

        try {
            this.limitDebt(request.getClient());
        } catch (LimitException e) {
            e.printStackTrace();
            this.rejectRequests.add(request);
        }
        this.approvedRequests.add(request);
    }

    private void canOrdering(Request request, Membership membership) throws CantOrderingException {

        if (request.isOrdering() != membership.isCanOrder()){
            throw new CantOrderingException("membership owned does not include ordering");
        }

    }

    private void limitOfCleaning(Client client, Membership membership) throws LimitException {
        if (client.getCleaning() >= membership.getLimitClean()){
            throw new LimitException("cleaning limit reached");
        }
    }

    private void limitOfOrdering(Client client, Membership membership) throws LimitException {
        if (client.getOrdering() >= membership.getLimitOrder()){
            throw new LimitException("order limit reached");
        }
    }

    private void limitDebt(Client client) throws LimitException {
        if (this.payment.getAmount(client.id) > client.getMembership().getLimitDebt()){
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
}
