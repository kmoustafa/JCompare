/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jcompare;

/**
 *
 * @author KimOoO
 */
public class Item {
    
    private int item_id;
    private String name;
    private int avaliable_quantity;
    private double price;
    private String category;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvaliable_quantity() {
        return avaliable_quantity;
    }

    public void setAvaliable_quantity(int avaliable_quantity) {
        this.avaliable_quantity = avaliable_quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
