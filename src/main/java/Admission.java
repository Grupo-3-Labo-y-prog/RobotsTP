import java.util.ArrayList;

public class Admission {

    private ArrayList<Request> approvedRequests;
    private ArrayList<Request> rejectRequests;
    private Payment payment;

    public void validMembership(Request request){

        Membership membership = request.getClient().getMembership();
        Client client = request.getClient();

        if (request.isOrdering() != membership.isCanOrder()){
            //throw
        }

        if (client.getCleaning() >= membership.getLimitClean()){
            //throw
        }

        if (client.getOrdering() >= membership.getLimitOrder()){
            //throw new Exception();
        }
    }

    public void validDebt(Client client){

        if (payment.getAmount(client.id) > client.getMembership().getLimitDebt()){
            //throw
        }
    }
}
