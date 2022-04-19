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
public class Cart {

    private String uId;
    private String pId;
    private int amount;

    public Cart() {
    }

    public Cart(String uId, String pId, int amount) {
        this.uId = uId;
        this.pId = pId;
        this.amount = amount;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
