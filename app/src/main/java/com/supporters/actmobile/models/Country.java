package com.supporters.actmobile.models;
/*
    com.supporters.actmobile.models
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import com.supporters.actmobile.ui.flaglist.FlagItem;

public class Country {
    public Country(String name, String code){
        this.name = name;
        this.code = code;
    }

    public Country(FlagItem flagItem){
        this.name = flagItem.getName();
        this.code = flagItem.getCode();
    }

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
