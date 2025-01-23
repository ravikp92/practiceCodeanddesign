package src.main.java.com.example.demo.designquestions.paymentgateway;

public class BankInstrument extends Instrument{
    String bankacntnumber;
    String ifscCode;

    public String getBankacntnumber() {
        return bankacntnumber;
    }

    public void setBankacntnumber(String bankacntnumber) {
        this.bankacntnumber = bankacntnumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}
