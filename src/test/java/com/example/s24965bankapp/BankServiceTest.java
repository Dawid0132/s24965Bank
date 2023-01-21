package com.example.s24965bankapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class BankServiceTest {

    ClientsStorage clientsStorage = new ClientsStorage();

    BankService bankService = new BankService(clientsStorage);


    @Test
    void shouldAddclient(){
        //given
        String ID = "123";
        float saldo = 5000.00f;
        String imię = "Adam";
        String nazwisko = "Mickiewicz";
        Client client;

        client = bankService.registerClient(ID,saldo,imię,nazwisko);

        Assertions.assertNotNull(client);
        //when
        //then
    }

    @Test
    void shouldoTransfer(){
        String ID = "1234";
        float transferValue = 4000.50f;

        Client client = new Client(ID, 5000.50f,"Jan","Matejko");

        TransferInfo transferInfo = bankService.doTransfer(ID,transferValue);

        Assertions.assertNotNull(transferInfo);

    }

    @Test
    void shouldgetClient(){
        String ID = "123";
        float saldo = 5000.00f;
        String imię = "Adam";
        String nazwisko = "Mickiewicz";

        Client client = bankService.registerClient(ID,saldo,imię,nazwisko);

        Assertions.assertNotNull(client);
    }

    @Test
    void shoulddrawMoney(){
        String ID = "1234";
        float transferValue = 4000.50f;

        Client client = new Client(ID, 5000.50f,"Jan","Matejko");

        TransferInfo transferInfo = bankService.moneyDraw(ID,transferValue);

        Assertions.assertNotNull(transferInfo);
    }
}
