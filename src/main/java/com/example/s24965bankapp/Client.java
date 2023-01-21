package com.example.s24965bankapp;

public class Client {
    private String ID;
    private float saldo;
    private String Imię;
    private String Nazwisko;

    public Client(String ID, float saldo, String imię, String nazwisko) {
        this.ID = ID;
        this.saldo = saldo;
        Imię = imię;
        Nazwisko = nazwisko;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public float getSaldo() {
        return saldo;
    }


    public String getID() {
        return ID;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID='" + ID + '\'' +
                ", saldo=" + saldo +
                ", Imię='" + Imię + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                '}';
    }
}
