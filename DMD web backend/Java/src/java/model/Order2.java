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
public class Order2 {

    private String category;
    private int collected;
    private int require;
    private String cateId;
    public Order2() {
    }

    public Order2(String category, int collected, int require, String cateId) {
        this.category = category;
        this.collected = collected;
        this.require = require;
        this.cateId = cateId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCollected() {
        return collected;
    }

    public void setCollected(int collected) {
        this.collected = collected;
    }

    public int getRequire() {
        return require;
    }

    public void setRequire(int require) {
        this.require = require;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    
    public boolean isEnough() {
        return collected - require >= 0;
    }

}
