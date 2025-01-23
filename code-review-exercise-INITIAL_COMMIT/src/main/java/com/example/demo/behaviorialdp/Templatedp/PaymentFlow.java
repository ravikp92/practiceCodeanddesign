package src.main.java.com.example.demo.behaviorialdp.Templatedp;

public abstract class PaymentFlow {
    abstract void validateReq();
    abstract void calculateFees();

    abstract void debit();

    abstract void credit();

//steps to follow
    public  final void sendMoney(){
        validateReq();
        calculateFees();
        debit();
        credit();
    }

}
