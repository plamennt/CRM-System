package com.CRMSystem.interfaces;

import com.CRMSystem.utility.Client;

import java.util.ArrayList;


public interface DataService {
    ArrayList<Client> readData();

    public void writeData(ArrayList<Client> clients);
}
