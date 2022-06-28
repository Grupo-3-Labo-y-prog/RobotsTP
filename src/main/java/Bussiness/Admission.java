package Bussiness;

import Entities.Request;
import Exceptions.CantOrderingException;
import Exceptions.LimitException;
import Memberships.Membership;
import PaymentDB.Payment;
import Services.Complex;
import Services.Simple;
import Services.Tasks;
import Services.TypeClean;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static Services.Waste.MUD;

public class Admission {

    private HashMap<Integer,Request> approvedRequests;
    private ArrayList<Request> rejectRequests;
    private Payment payment;

    public void validMembership(Request request) throws CantOrderingException, LimitException {

        Membership membership = request.getClient().getMembership();

        this.canOrdering(request, membership);
        this.limitOfCleaning(request);
        this.limitOfOrdering(request);

    }

    public void validDebt(Request request) throws LimitException {

        this.limitDebt(request);

    }

    private void canOrdering(Request request, Membership membership) throws CantOrderingException {

        boolean askOrdering = request.getRequestedTasks().contains(Tasks.ORDERING);
        if (askOrdering) {
            if (askOrdering != membership.isCanOrder()){
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
        if (this.payment.getAmount(request.getClient().getId()) > request.getClient().getMembership().getLimitDebt()){
            this.addRejected(request);
            throw new LimitException("the limit of the debt has been reached");
        }
    }

    public HashMap<Integer, Request> getApprovedRequests() {
        return approvedRequests;
    }

    public void setApprovedRequests(HashMap<Integer, Request> approvedRequests) {
        this.approvedRequests = approvedRequests;
    }

    public ArrayList<Request> getRejectRequests() {
        return rejectRequests;
    }

    public void setRejectRequests(ArrayList<Request> rejectRequests) {
        this.rejectRequests = rejectRequests;
    }

    public Admission(HashMap<Integer,Request> approvedRequests, ArrayList<Request> rejectRequests, Payment payment) {
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

    public int findDifference(LocalDate start_date, LocalDate end_date) {

        Duration diff = Duration.between(start_date.atStartOfDay(), end_date.atStartOfDay());
        return (int) diff.toDays();
    }

    public int DaysDiference(Request request) {

        LocalDate start_date = request.getLastCleanning();
        LocalDate end_date = LocalDate.now();

        return findDifference(start_date, end_date);
    }

    public void setTypeClean(Request request) {

        if (DaysDiference(request) >= 15 || request.getPets() > 1 || request.getWastes().contains(MUD)) {

            request.setTypeCleanning(new Complex()); ;
        }
        else {
            request.setTypeCleanning(new Simple());
        }

    }

}
