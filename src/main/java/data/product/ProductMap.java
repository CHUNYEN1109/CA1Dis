/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.product;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author brad1109
 */
public class ProductMap {
    private final Map<Product, Integer> productDB;
    // constructor
    public ProductMap(){
        // HashMap; key = Product, value = impactPoint
        productDB = new HashMap<>();

        // initialized and create product
        // String productId, String name, double carbon, String manufactuer, String decription
        Product p1 = new Product("A01", "Hoodie", 7.8, "Zara", "Cotton");
        Product p2 = new Product("A02", "Jeans", 33.4, "Diesal", "Denim");
        Product p3 = new Product("A03", "Shirt", 5.8, "Uniqlo", "Spandex");
        // store in productDB
        productDB.put(p1, -7);
        productDB.put(p2, -33);
        productDB.put(p3, -5);
    }
    // method
    public void toPrint(){
        // Lambada 
        productDB.forEach((key, value) ->{
            System.out.println("Product: " + key + "\nImpact point: " + value);
        });
    }
    
    public Product getInfoById(String id){
        for(Product p : productDB.keySet()){
            if(p.getProductId().equals(id)) return p;
        }
        return null;
    
    }
    
        public int getImapcById(String id){
        for(Map.Entry<Product, Integer> e: productDB.entrySet()){
            if(e.getKey().getProductId().equals(id)) return e.getValue();
        }
        return 0;
    
    }
    

    
    // main for test 
    public static void main(String[] args){
        ProductMap pm = new ProductMap();
        // Output
        pm.toPrint();
        System.out.println("getInfoById TEST");
        Product p  = pm.getInfoById("A01");
        System.out.println(p);

        
    }
}
