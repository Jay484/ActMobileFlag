package com.supporters.actmobile.models;
/*
    com.supporters.actmobile.models
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import java.util.ArrayList;

public class CountryResponse {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<Country> getResult() {
        return result;
    }

    public void setResult(ArrayList<Country> result) {
        this.result = result;
    }

    int code;
    ArrayList<Country> result;
}
