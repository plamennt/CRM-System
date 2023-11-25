package com.CRMSystem.clientManager;

import com.CRMSystem.dataService.ClientService;
import com.CRMSystem.utility.Client;

import java.util.Scanner;

public class ClientManager {
    private ClientService clientService;
    private Scanner sc;

    public ClientManager(ClientService clientService) {
        this.clientService = clientService;
        this.sc = new Scanner(System.in);
    }

    public void performAction(char command) {
        switch (command) {
            case '1':
            case '2':
                System.out.println("Please enter client information:");
                System.out.println("ID, Name, Industry, Contact Person, Revenue");

                String[] input = sc.nextLine().split(",");
                String id = input[0].trim();
                String name = input[1].trim();
                String industry = input[2].trim();
                String contactPerson = input[3].trim();
                double revenue = Double.parseDouble(input[4].trim());

                Client client = new Client(id, name, industry, contactPerson, revenue);

                if (command == '1') {
                    clientService.addClient(client);
                } else {
                    clientService.updateClient(client);
                }
                break;
            case '3':
                clientService.viewClients();
                System.out.println("\nWhich client would you like to remove?");
                System.out.println("Please enter client ID.");
                String clientId = sc.nextLine();
                clientService.removeClient(clientId);
                break;
            case '4':
                clientService.viewClients();
                break;
        }
    }
}
