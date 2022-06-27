import Bussiness.Admission;
import Entities.Client;
import Entities.Report;
import Entities.Request;
import Exceptions.CantOrderingException;
import Exceptions.LimitException;
import Memberships.Classic;
import Memberships.Economic;
import Memberships.Membership;
import Memberships.Platinum;
import PaymentDB.Debt;
import PaymentDB.Payment;
import Services.Complex;
import Services.Simple;
import Services.Tasks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReportTest {

    Client client1;
    Client client2;
    Request request;
    Report report;
    Integer id;
    HashMap<Integer,Request> requests = new HashMap<>();

    @BeforeEach
    void SetUp(){
        report = new Report();
        Request request = new Request(5,this.client1, new ArrayList<>(), new Complex(), "Siempre viva 1234");
        Request request2 = new Request(8,this.client2, new ArrayList<>(), new Complex(), "Emilio Frers 2048, Martinez");
        requests.put(1, request);
        requests.put(2,request2);
    }

    @Test
    void quantityPerTypeTest() {



        assertEquals("Complex: 2 vs Simple: 0", this.report.quantityPerType(requests));
    }


}
