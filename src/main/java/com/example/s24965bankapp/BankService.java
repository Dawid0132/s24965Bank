package com.example.s24965bankapp;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class BankService {
    private ClientsStorage clientsStorage;

    public BankService(ClientsStorage clientsStorage) {
        this.clientsStorage = clientsStorage;
    }

    public List<Client> getAllClients(){
        return clientsStorage.getClients();
    }

    private float calculate(float saldo, float transferValue){
        return saldo - transferValue;
    }

    private float calculateDrawMoney(float saldo, float transferDraw){
        return saldo + transferDraw;
    }


    public Client registerClient(String ID, float saldo, String imię, String nazwisko){
        int length = getAllClients().size();
        getAllClients().add(new Client(ID,saldo,imię,nazwisko));
        if (length == length + 1){
            return new Client(ID,saldo,imię,nazwisko);
        }else {
            return null;
        }
    }


    public Client getClient(String ID){
        for (Client client: getAllClients()) {
            if (client.getID().equals(ID)){
                return client;
            }
        }
        return null;
    }


    public TransferInfo doTransfer(String ID,float transferValue){
        Client client = clientsStorage.findClientID(ID);
        
        boolean istnieje = false;
        
        if (client == null){
            System.out.println("Nie mamy takiego klienta");
            return null;
        }else {
            istnieje = true;
        }

        if (istnieje){
            for (Client user : getAllClients()) {
                if (user.getID().equals(client.getID())){
                    if (calculate(user.getSaldo(),transferValue)<0){
                        System.out.println("Sprawdz saldo");
                    }else {
                        return new TransferInfo(calculate(user.getSaldo(), transferValue));
                    }
                }
            }
        }
        return null;
    }

    public TransferInfo moneyDraw(String ID, float value){
            Client client = clientsStorage.findClientID(ID);

            boolean istnieje = false;

            if (client == null){
                System.out.println("Nie mamy takiego klienta");
                return null;
            }else {
                istnieje = true;
            }

            if (istnieje){
                for (Client user: getAllClients()) {
                    if (user.getID().equals(client.getID())){
                        return new TransferInfo(calculateDrawMoney(user.getSaldo(),value));
                    }
                }
            }
        return null;
    }
}
