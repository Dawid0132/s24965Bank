package com.example.s24965bankapp;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientsStorage {
    private Client client1 =  new Client("123",  5000.45f,"Jan","Kowalski");
    private Client client2 = new Client("1234",10000.56f,"Pan","Tadeusz");
    private Client client3 = new Client("543",7000.23f,"Adam","Mickiewicz");


    List<Client> clients = new ArrayList<>();

    public ClientsStorage() {
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
    }


    public Client findClientID(String ID){
        for (Client client: clients) {
            if (client.getID().equals(ID)){
                return clients.get(clients.indexOf(client));
            }
        }
        return null;
    }

    public Client getClient1() {
        return client1;
    }

    public Client getClient2() {
        return client2;
    }

    public Client getClient3() {
        return client3;
    }

    public void setClient1(Client client1) {
        this.client1 = client1;
    }

    public void setClient2(Client client2) {
        this.client2 = client2;
    }

    public void setClient3(Client client3) {
        this.client3 = client3;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }
}
