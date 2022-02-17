package com.example.childrenschool.BloodBank.addDonor.donorModel;

public class DonorData {
    String name, bacth, contact, bg, weight;

    public DonorData(String name, String bacth, String contact, String bg, String weight) {
        this.name = name;
        this.bacth = bacth;
        this.contact = contact;
        this.bg = bg;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBacth() {
        return bacth;
    }

    public void setBacth(String bacth) {
        this.bacth = bacth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
