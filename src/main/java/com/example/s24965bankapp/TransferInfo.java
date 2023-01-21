package com.example.s24965bankapp;

import java.time.LocalDate;

public class TransferInfo {
    private float status;

    public TransferInfo(float status) {
        this.status = status;
    }

    public void setStatus(float status) {
        this.status = status;
    }


    public float getStatus() {
        return status;
    }

}
