import Bussiness.Admission;
import Entities.Client;
import Entities.Request;
import Exceptions.CantOrderingException;
import Exceptions.LimitException;
import Memberships.Classic;
import Memberships.Economic;
import Memberships.Membership;
import PaymentDB.Debt;
import PaymentDB.Payment;
import Services.Complex;
import Services.Simple;
import Services.Tasks;
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
        this.client = new Client(1111, new Classic(), 0, 0, new ArrayList<>());
        this.request = new Request(222, this.client, new ArrayList<>(), new Simple(), "Maipu 1234");
        this.admission = new Admission(new ArrayList<>(), new ArrayList<>(), new Payment(new
                HashMap<>()));
    }

    @Test
    void validMembership(){

        this.membership = new Classic();
        this.client = new Client(1515, this.membership, 0,0,new ArrayList<>());
        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.ORDERING);
        tasks.add(Tasks.CLEANNING);
        this.request = new Request(4545, this.client,tasks, new Simple(), "avmaipu1212");

        assertDoesNotThrow(()-> this.admission.validMembership(this.request));
    }

    @Test
    void validMembershipEconomicWithOrdering(){
        this.membership = new Economic();
        this.client = new Client(1111, this.membership, 0,0, new ArrayList<>());
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        task.add(Tasks.ORDERING);
        task.add(Tasks.CLEANNING);
        this.request = new Request(2222, this.client, task, new Simple(), "Maipu 1234");

        assertThrows(CantOrderingException.class, () ->this.admission.validMembership(request));
    }

    @Test
    void validMembershipEconomicThrowsLimitEx(){
        this.membership =  new Economic();
        this.client = new Client(1212, this.membership, 0,3, new ArrayList<>());
        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        this.request = new Request(3333, this.client, tasks, new Complex(), "Maipu 1234");

        assertThrows(LimitException.class, () ->this.admission.validMembership(this.request));
    }

    @Test
    void validMembershipThrowsLimitEx(){
        this.membership =  new Classic();
        this.client = new Client(1212, this.membership, 3,0, new ArrayList<>());
        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        tasks.add(Tasks.ORDERING);
        this.request = new Request(3333, this.client, tasks, new Complex(), "Maipu 1234");

        assertThrows(LimitException.class, () ->this.admission.validMembership(this.request));
    }

    @Test
    void validDebt() {
        this.client.setMembership(new Classic());
        this.admission.getPayment().getClients().put(this.client.getId(), new Debt(this.client.getId(), 0));
        assertDoesNotThrow(()-> this.admission.validDebt(this.request));
    }

    @Test
    void validDebtWithDebt() {
        this.client.setMembership(new Classic());
        this.admission.getPayment().getClients().put(this.client.getId(), new Debt(this.client.getId(), 2000));
        assertThrows(LimitException.class, () -> this.admission.validDebt(this.request));
    }
    
}