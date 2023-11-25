package com.CRMSystem.utility;

public class Client {
    private String id;
    private String name;
    private String industry;
    private String contactPerson;
    private double revenue;

    public Client(String id, String name, String industry, String contactPerson, double revenue) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = revenue;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public double getRevenue() {
        return revenue;
    }

    @Override
    public String toString() {
        return "\nID: " + id + ",\nName: " + name + ",\nIndustry: " + industry +
                ",\nContact Person: " + contactPerson + ",\nRevenue: " + revenue;
    }
}
