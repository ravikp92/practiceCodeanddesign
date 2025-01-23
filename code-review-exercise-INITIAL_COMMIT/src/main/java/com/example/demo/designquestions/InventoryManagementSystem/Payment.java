package src.main.java.com.example.demo.designquestions.InventoryManagementSystem;


public class Payment {

   PaymentMode paymentMode;

   Payment(PaymentMode paymentMode){
       this.paymentMode = paymentMode;
   }

    public boolean makePayment(){
        return paymentMode.makePayment();
    }

}
