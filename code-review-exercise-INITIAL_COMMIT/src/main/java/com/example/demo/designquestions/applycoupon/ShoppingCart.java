package src.main.java.com.example.demo.designquestions.applycoupon;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> products;

    public ShoppingCart(){
        products=new ArrayList<>();
    }
    public void addToCart(Product product){
    Product productEligibleDiscount= new TypeCouponDecorator(new PercentCouponDecorator(product,
            10),5,product.getProductType());
    System.out.println("Product : "+product.getName()+" after discount: "+productEligibleDiscount.getPrice());
    products.add(productEligibleDiscount);
    }

    public double getTotalPrice(){
        double total=0;
        for(Product product:products){
            total+=product.getPrice();
        }
        return total;
    }

}
