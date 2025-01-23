package src.main.java.com.example.demo.designquestions.applycoupon;

public class PercentCouponDecorator extends CouponDecorator{

    Product product;
    int percentage;

    public PercentCouponDecorator(Product product, int percentage) {
        this.product = product;
        this.percentage = percentage;
    }

    @Override
    public double getPrice() {
        double price=product.getPrice();
        return price-(price*percentage)/100;
    }
}
