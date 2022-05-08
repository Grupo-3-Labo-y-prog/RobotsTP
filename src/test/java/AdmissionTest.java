import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AdmissionTest {

    Membership membership;
    Client client;
    Request request;
    Admission admission;

    @BeforeEach
    void setUp() {
        this.client = new Client(1111, new Classic(), 0, 0);
        this.request = new Request(222, this.client, new ArrayList<Tasks>(), new Simple());
        this.admission = new Admission(new ArrayList<Request>(), new ArrayList<Request>(), new Payment(new
                HashMap<Integer, Debt>()));
    }

    @Test
    void validMembership(){}

    @Test
    void validMembershipEconomicWithOrdering(){
        this.membership = new Economic();
        this.client = new Client(1111, this.membership, 0,0);
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        task.add(Tasks.ORDERING);
        task.add(Tasks.CLEANING);
        this.request = new Request(2222, this.client, task, new Simple());

        assertThrows(CantOrderingException.class, () ->this.admission.validMembership(request));
    }

    @Test
    void validDebt() {
    }

    @Test
    void validDebtWithDebt() {
        this.client.setMembership(new Classic());
        this.admission.getPayment().getClients().put(this.client.getId(), new Debt(this.client.getId(), 2000));
        assertThrows(LimitException.class, () -> this.admission.validDebt(this.request));
    }
    
}