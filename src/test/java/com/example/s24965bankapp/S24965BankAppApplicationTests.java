package com.example.s24965bankapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class S24965BankAppApplicationTests {

    @MockBean
    ClientsStorage clientsStorage = new ClientsStorage();

    @Autowired
    BankService bankService = new BankService(clientsStorage);

    @Test
    void contextLoads() {
    }

}
