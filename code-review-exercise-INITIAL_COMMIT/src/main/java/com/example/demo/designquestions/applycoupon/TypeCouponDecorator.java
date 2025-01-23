package src.main.java.com.example.demo.designquestions.applycoupon;

import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator{

    Product product;
    int percentage;

    ProductType type;

    static List<ProductType> eligibletypes=new ArrayList<>();

    static{
        eligibletypes.add(ProductType.ELECTRONICS);
        eligibletypes.add(ProductType.MOBILE);
    }

    public TypeCouponDecorator(Product product, int percentage, ProductType type) {
        this.product = product;
        this.percentage = percentage;
        this.type = type;
    }

    @Override
    public double getPrice() {

        double price=product.getPrice();
        if(eligibletypes.contains(type)){
            return price - (price * percentage)/100;
        }
        return price;
    }
}
