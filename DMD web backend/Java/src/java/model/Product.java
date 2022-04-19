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
public class Product {

    private String pId;
    private String name;
    private String img;
    private int price;
    private String desc;
    private String cateId;

    public Product() {
    }

    public Product(String pId, String name, String img, int price, String desc, String cateId) {
        this.pId = pId;
        this.name = name;
        this.img = img;
        this.price = price;
        this.desc = desc;
        this.cateId = cateId;
    }

    public String getpId() {
        return pId.trim();
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

}
