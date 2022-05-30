package com.supporters.actmobile.ui.flaglist;
/*
    com.supporters.actmobile.ui.FlagList
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import com.supporters.actmobile.models.Country;

public class FlagItem {
    private String name;
    private String code;
    private Boolean isSelected;

    public FlagItem(Country country, Boolean isSelected){
        this.name = country.getName();
        this.code = country.getCode();
        this.isSelected = isSelected;
    }
    public FlagItem(Country country){
        this.name = country.getName();
        this.code = country.getCode();
        this.isSelected = false;
    }

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

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

}
