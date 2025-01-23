package src.main.java.com.example.demo.behaviorialdp.Templatedp;

public class ClientTemplate {

    public static void main(String[] args) {
        PaymentFlow paytoFriend = new PaytoFriend();
        paytoFriend.sendMoney();

        PaymentFlow payToMerchant = new PayToMerchant();
        payToMerchant.sendMoney();
    }
}
