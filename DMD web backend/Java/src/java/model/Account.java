/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Trong Thinh
 */
public class Account {

    private String uId;
    private String paswrod;
    private String name;
    private String type;

    public Account() {
    }

    public Account(String uId, String paswrod, String name, String type) {
        this.uId = uId;
        this.paswrod = paswrod;
        this.name = name;
        this.type = type;
    }

    public String getuId() {
        return uId.trim();
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getPaswrod() {
        return paswrod.trim();
    }

    public void setPaswrod(String paswrod) {
        this.paswrod = paswrod;
    }

    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type.trim();
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAdmin() {
        if (type.trim().equals("Admin")) {
            return true;
        }
        return false;
    }

    public boolean isEmployee() {
        if (type.trim().equals("employee")) {
            return true;
        }
        return false;
    }

    public boolean isCustomer() {
        if (type.trim().equals("customer")) {

            return true;
        }
        return false;
    }

}
