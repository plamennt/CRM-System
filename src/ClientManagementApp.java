import com.CRMSystem.clientManager.ClientManager;
import com.CRMSystem.dataService.CSVDataService;
import com.CRMSystem.dataService.ClientService;
import com.CRMSystem.interfaces.DataService;

import java.io.*;
import java.util.Scanner;

public class ClientManagementApp {
    public static void main(String[] args) {

//        Service service = new ClientService(fileReader, fileWriter);
//        Manager manager = new ClientManager(service);

        DataService dataService = new CSVDataService("C:\\Users\\Plamen Tashkov\\" +
                "IdeaProjects\\CRMSystem\\src\\com\\In_Out_files\\csvIn.csv");
        ClientService clientService = new ClientService(dataService);
        ClientManager manager = new ClientManager(clientService);

        System.out.println("\nWelcome to the CRM System");

        //boolean active = true;
        Scanner sc = new Scanner(System.in);
        String command = "";

        try {
            do {
                displayOptions();
                command = sc.nextLine();

                if (command.length() == 1) {
                    switch (command.charAt(0)) {
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                            manager.performAction(command.charAt(0));
                            break;
                        case '9':
                            clientService.writeData(clientService.readData());
                            System.out.println("Saved & Exit");
                            break;
                    }
                } else {
                    System.out.println("Error: Invalid input!\n");
                    displayOptions();
                }
            } while (command.charAt(0) != '9' || command.length() != 1);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Empty input received. Exiting program...");
        }
    }

    private static void displayOptions() {
        System.out.println("\nAvailable options:");
        System.out.println("1. Add Client");
        System.out.println("2. Update Client");
        System.out.println("3. Remove Client");
        System.out.println("4. View Client");
        System.out.println("9. Save & Exit");
    }
}
