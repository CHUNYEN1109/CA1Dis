/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.product;

/**
 *
 * @author brad1109
 */
public class Product {
    private String productId;
    private String name;
    private double carbon;
    private String manufactuer;
    private String decription;

    public Product() {
    }

    public Product(String productId, String name, double carbon, String manufactuer, String decription) {
        this.productId = productId;
        this.name = name;
        this.carbon = carbon;
        this.manufactuer = manufactuer;
        this.decription = decription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCarbon() {
        return carbon;
    }

    public void setCarbon(double carbon) {
        this.carbon = carbon;
    }

    public String getManufactuer() {
        return manufactuer;
    }

    public void setManufactuer(String manufactuer) {
        this.manufactuer = manufactuer;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", carbon=" + carbon + ", manufactuer=" + manufactuer + ", decription=" + decription + '}';
    }
    

}
