import Comunications.Comunication;
import Entities.Client;
import Entities.Request;
import Memberships.Economic;
import Services.Simple;
import Services.Tasks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComunicationTest {
    Client client;
    Comunication comunication;

    Request request;

    @BeforeEach
    void setUp() {
        this.client = new Client();
        this.comunication = new Comunication();
        this.request = new Request();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void printBill() {
    }

    @Test
    void receivesClient() {
    }

    @Test
    void receivesId() {
    }

    @Test
    void receivesRequest() {
        this.client.setMembership(new Economic());
        this.client.setId(123);
        this.client.setCleaning(1);
        this.client.setOrdering(0);

        this.request.setID(123);
        this.request.setAddress("Av.Maipu 123");
        this.request.setClient(this.client);
        this.request.setCleaning(new Simple());
        this.request.setRequestedTasks(new ArrayList<>());
        this.request.getRequestedTasks().add(Tasks.CLEANNING);
        this.request.getRequestedTasks().add(Tasks.ORDERING);

        assertEquals(this.request, this.comunication.receivesRequest(this.client));

    }
}