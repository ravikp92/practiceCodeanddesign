package src.main.java.com.example.demo.designquestions.applycoupon;

public class CouponMain {

    public static void main(String[] args) {
        Product item1=new Item1("iphone",50000,ProductType.MOBILE);
        Product item2=new Item1("furniture",10000,ProductType.FURNITURE);

        ShoppingCart shoppingCart=new ShoppingCart();

        shoppingCart.addToCart(item1);
        shoppingCart.addToCart(item2);

        System.out.println("Price after discount: "+shoppingCart.getTotalPrice());
    }
}
