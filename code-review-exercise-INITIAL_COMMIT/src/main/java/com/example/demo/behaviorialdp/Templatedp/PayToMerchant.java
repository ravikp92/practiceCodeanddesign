package src.main.java.com.example.demo.behaviorialdp.Templatedp;

public class PayToMerchant extends PaymentFlow{
    @Override
    void validateReq() {
        System.out.println("PayToMerchant.validatereq");

    }

    @Override
    void calculateFees() {
        System.out.println("PayToMerchant.calculateFees");

    }

    @Override
    void debit() {
        System.out.println("PayToMerchant.debit");

    }

    @Override
    void credit() {
        System.out.println("PayToMerchant.credit");

    }
}
