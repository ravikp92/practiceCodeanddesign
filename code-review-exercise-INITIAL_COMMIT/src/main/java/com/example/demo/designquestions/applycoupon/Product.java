package src.main.java.com.example.demo.designquestions.applycoupon;

public abstract class Product {
    String name;
    double price;
    ProductType productType;

    Product(){}
    public Product(String name, double price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }
    public abstract double getPrice();

    public ProductType getProductType(){
        return productType;
    }

    public  String getName(){
        return name;
    }
}
