package src.main.java.com.example.demo.designquestions.paymentgateway;

public class CardInstrument extends Instrument{
    String cardnumber;
    String ccv;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
}
