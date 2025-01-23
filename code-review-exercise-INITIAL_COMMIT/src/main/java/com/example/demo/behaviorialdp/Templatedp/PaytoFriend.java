package src.main.java.com.example.demo.behaviorialdp.Templatedp;

public class PaytoFriend extends PaymentFlow{
    @Override
    void validateReq() {
        System.out.println("Paytofriend.validatereq");
    }

    @Override
    void calculateFees() {
        System.out.println("Paytofriend.calculateFees");

    }

    @Override
    void debit() {
        System.out.println("Paytofriend.debit");


    }

    @Override
    void credit() {
        System.out.println("Paytofriend.credit");

    }
}
