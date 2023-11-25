package com.CRMSystem.dataService;

import com.CRMSystem.interfaces.DataService;
import com.CRMSystem.utility.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientService implements DataService {
    private ArrayList<Client> clients;
    private DataService dataService;
    private Scanner sc;

    public ClientService(DataService dataService) {
        this.dataService = dataService;
        this.clients = dataService.readData();
        this.sc = new Scanner(System.in);
    }

    @Override
    public ArrayList<Client> readData() {
        return this.clients;
    }

    @Override
    public void writeData(ArrayList<Client> clients) {
        dataService.writeData(clients);
    }

    public void addClient(Client client) {
        boolean flag = true;
        String input = "";

        for (Client currentClient : clients) {
            if (currentClient.getId().equals(client.getId())) {
                System.out.println("Client whit ID " + client.getId() + " already exists.");
                flag = false;

                System.out.println("Would you like to update this client?");
                System.out.println("Please type Y/N");
                input = sc.nextLine();

                if (input.equals("Y")) {
                    updateClient(client);
                } else {
                    break;
                }
                break;
            }
        }
        if (flag) {
            clients.add(client);
            System.out.println("Client added successfully.");
        }

    }

    public void updateClient(Client client) {
        int index = 0;

        for (Client currentClient : clients) {
            if (currentClient.getId().equals(client.getId())) {
                index = clients.indexOf(currentClient);
                break;
            }
        }
        if (index != -1) {
            clients.set(index, client);
            System.out.println("Client updated successfully.");
        } else {
            System.out.println("Client with ID " + client.getId() + "not found.");
        }
    }

    public void removeClient(String clientId) {
        clients.removeIf(client -> client.getId().equals(clientId));
        System.out.println("Client removed successfully.");
    }

    public void viewClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            for (Client client : clients) {
                System.out.println(client);
            }
        }
    }
}
