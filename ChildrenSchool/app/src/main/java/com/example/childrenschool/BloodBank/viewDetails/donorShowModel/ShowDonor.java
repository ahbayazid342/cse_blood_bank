package com.example.childrenschool.BloodBank.viewDetails.donorShowModel;

public class ShowDonor {
    String batch, bg, contact, name, weight;

    public ShowDonor(String batch, String bg, String contact, String name, String weight) {
        this.batch = batch;
        this.bg = bg;
        this.contact = contact;
        this.name = name;
        this.weight = weight;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
