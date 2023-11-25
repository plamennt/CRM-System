package com.CRMSystem.dataService;

import com.CRMSystem.interfaces.DataService;
import com.CRMSystem.utility.Client;

import java.io.*;
import java.util.ArrayList;

public class CSVDataService implements DataService {
    private String filePath;

    public CSVDataService(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public ArrayList<Client> readData() {
        ArrayList<Client> clients = new ArrayList<>();
        int counter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                counter++;
                if(counter >1){
                    Client client = parseCSVLine(line);
                    clients.add(client);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void writeData(ArrayList<Client> clients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Industry,ContactPerson,Revenue");
            writer.newLine();

            for (Client client : clients) {
                writer.write(client.getId() + "," + client.getName() + "," +
                        client.getIndustry() + "," + client.getContactPerson() + "," +
                        client.getRevenue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Client parseCSVLine(String line) {
        String[] values = line.split(",");
        String id = values[0].trim();
        String name = values[1].trim();
        String industry = values[2].trim();
        String contactPerson = values[3].trim();
        double revenue = Double.parseDouble(values[4].trim());
        return new Client(id, name, industry, contactPerson, revenue);
    }
}
