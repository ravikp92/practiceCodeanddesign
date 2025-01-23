package src.main.java.com.example.demo.designquestions.applycoupon;

public class Item1 extends Product{

    Item1(String name, double price, ProductType productType){
        super(name, price, productType);
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
