import Bussiness.Admission;
import Entities.*;
import Memberships.Platinum;
import PaymentDB.Payment;
import Services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReportTest {

    Client client1 = new Client();
    Client client2 = new Client();;
    Report report;
    Admission admission;

    Integer id;
    HashMap<Integer,Request> requests = new HashMap<>();

    @BeforeEach
    void SetUp(){
        report = new Report();
        Request request = new Request(1,this.client1, new ArrayList<>(), new Complex(), "Siempre viva 1234");
        Request request1 = new Request(1,this.client1, new ArrayList<>(), new Complex(), "Siempre viva 1234");
        Request request2 = new Request(2,this.client2, new ArrayList<>(), new Complex(), "Emilio Frers 2048, Martinez");
        requests.put(1, request);
        requests.put(2,request2);
        admission = new Admission(new HashMap<>(),new ArrayList<>(), new Payment(new HashMap<>()));
    }

    @Test
    void quantityPerTypeTestNoTypeClean() {
        TreeSet<Waste> waste = new TreeSet<>();
        waste.add(Waste.DUST);
        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        tasks.add(Tasks.ORDERING);
        ArrayList<Service> services = new ArrayList<>();
        services.add(new Gas(2,new Employee(1)));
        Request request = new Request(3,new Client(), tasks, services, "Siempre viva 1234", waste,2, LocalDate.now().minusDays(3));
        this.requests.put(3, request);
        Request request2 = new Request(4,this.client1, new ArrayList<>(), new Simple(), "Siempre viva 1234");
        this.requests.put(4,request2);
        AmountOfCleaning expected = new AmountOfCleaning();
        expected.setAmountOfComplex(2);
        expected.setAmountOfSimple(1);

        assertEquals(expected.getAmountOfComplex(), this.report.quantityPerType(requests).getAmountOfComplex());
        assertEquals(expected.getAmountOfSimple(), this.report.quantityPerType(requests).getAmountOfSimple());
    }

    @Test
    void quantityPerTypeTest() {
        AmountOfCleaning expected = new AmountOfCleaning();
        expected.setAmountOfComplex(2);
        expected.setAmountOfSimple(0);

        assertEquals(expected.getAmountOfComplex(), this.report.quantityPerType(requests).getAmountOfComplex());
        assertEquals(expected.getAmountOfSimple(), this.report.quantityPerType(requests).getAmountOfSimple());
    }

    //Se desean conocer los costos generados del cliente ID 1 quien realizó dos solicitudes en el mes.
    @Test
    void costPerClientTest(){

        Employee employee = new Employee(1);
        HashSet <Employee> employees = new HashSet<>();
        employees.add(employee);

        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        tasks.add(Tasks.ORDERING);
        TreeSet<Waste> waste = new TreeSet<>();
        waste.add(Waste.DUST);

        ArrayList<Service> services = new ArrayList<>();
        services.add(new Gas(2,new Employee(1)));
        services.add(new Electricity(7, new Employee(1)));

        Request request1 = new Request(1,client1,tasks,services,"Calle Wallaby 42", waste,2, LocalDate.now().minusDays(3));
        request1.setTypeCleanning(new Complex());

        Request request2 = new Request(1,client1,tasks,services,"Calle Wallaby 42", waste,0, LocalDate.now().minusDays(1));
        request2.setTypeCleanning(new Simple());


        ArrayList<Request> requestList = new ArrayList<>();
        requestList.add(request1);
        requestList.add(request2);

        client1 = new Client(1,new Platinum(),1,2, requestList);

        client1.getRequests().add(request1);
        client1.getRequests().add(request2);
        client2.getRequests().add(request1);

        HashMap<Integer, Client> clientes = new HashMap<>();
        clientes.put(1,client1);
        clientes.put(2,client2);



        assertEquals(44686,this.report.costPerClient(clientes,1));
    }

    //Se desean conocer los costos de una solicitud particular.
    @Test
    void costPerRequest(){
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        HashSet <Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        ArrayList<Tasks> tasks = new ArrayList<>();
        tasks.add(Tasks.CLEANNING);
        tasks.add(Tasks.ORDERING);

        TreeSet<Waste> waste = new TreeSet<>();
        waste.add(Waste.MUD);
        waste.add(Waste.DUST);

        ArrayList<Service> services = new ArrayList<>();
        services.add(new Gas(2,new Employee(1)));
        services.add(new Electricity(7, new Employee(2)));


        Request request1 = new Request(1,client1,tasks,services,"Calle Wallaby 42", waste,2, LocalDate.now().minusDays(3));
        request1.setTypeCleanning(new Complex());

        Request request2 = new Request(2,client2,tasks,services,"Calle Wallaby 42", waste,0, LocalDate.now().minusDays(111));
        admission.setTypeClean(request2);

        HashMap<Integer,Request> requests = new HashMap<>();
        requests.put(1,request1);
        requests.put(2,request2);//11171.5


        assertEquals(11171.5, this.report.costPerRequest(requests,2));
    }
}
