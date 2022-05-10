import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Comunication {
    private int numberRequest = 0;

    public void printBill(Request request, HashSet<Robot> robots){
        System.out.println("Factura");
        System.out.println(request);
        System.out.println(robots);
    }

    public Client receivesClient(int id){
        Client clientNew = new Client();
        clientNew.setId(id);

        System.out.println("Seleccionar membresia: 1- ECONOMIC | 2- CLASSIC | 3- PLATINUM");
        Scanner buffer = new Scanner(System.in);
        int option = buffer.nextInt();

        if(option == 1){
            clientNew.setMembership(new Economic());
        }else if(option == 2){
            clientNew.setMembership(new Classic());
        }else{
            clientNew.setMembership(new Platinum());
        }

        int ordering = 0;
        int cleaning = 0;

        clientNew.setOrdering(ordering);
        clientNew.setCleaning(cleaning);

        return clientNew;
    }

    public int receivesId(){
        Scanner buffer = new Scanner(System.in);

        System.out.println("Ingrese el ID del cliente:");
        int id = buffer.nextInt();
        return id;
    }

    public Request receivesRequest(Client client) {
        Scanner buffer = new Scanner(System.in);
        Request request = new Request();

        request.setClient(client);

        System.out.println("ingrese direccion:");
        request.setAddress(buffer.nextLine());

        System.out.println("1 - Limpieza Simple | 2 - Limpieza Compleja ");
        int option = buffer.nextInt();

        try {
            if (option == 1) {
                request.setCleaning(new Simple());
            } else if (option == 2) {
                request.setCleaning(new Complex());
            } else {
                throw new WrongAnswerException("Opcion de tipo de limpieza incorrecto");

            }

            ArrayList<Tasks> tasks = new ArrayList<>();
            tasks.add(Tasks.CLEANNING);

            System.out.println("Desea lustrar Si|No?");
            String option2 = buffer.nextLine();

            if (option2 != "Si" && option2 != "No"){
                throw new WrongAnswerException("Opcion de lustrar es incorrecta");
            }
            if (option2 == "Si") {
                tasks.add(Tasks.POLISHING);
            }


            System.out.println("Desea ordenar Si|No?");
            String option3 = buffer.nextLine();
            if(option3 != "Si" && option3 != "No"){
                throw new WrongAnswerException("Opcion de ordenamiento incorrecta");
            }

            if (option3 == "Si") {
                tasks.add(Tasks.ORDERING);
            }

            request.setRequestedTasks(tasks);

            this.numberRequest++;
            request.setID(this.numberRequest);
        } catch (WrongAnswerException e) {
            e.printStackTrace();


        }

        return request;
    }
}
