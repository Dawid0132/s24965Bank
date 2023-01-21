package com.example.s24965bankapp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankServiceMock {

    @Mock
    ClientsStorage clientsStorage = new ClientsStorage();

    @InjectMocks
    BankService bankService = new BankService(clientsStorage);

    @Test
    void shouldAddclient(){
        String ID = "123";
        float saldo = 5000.00f;
        String imię = "Adam";
        String nazwisko = "Mickiewicz";
        //given
        Client client;

        when(bankService.registerClient(ID,saldo,imię,nazwisko).thenReturn(bankService.getAllClients()));

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

        when(bankService.getClient(ID));

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
