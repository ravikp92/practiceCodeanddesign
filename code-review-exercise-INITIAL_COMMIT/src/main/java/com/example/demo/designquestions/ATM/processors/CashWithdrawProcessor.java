package src.main.java.com.example.demo.designquestions.ATM.processors;

import src.main.java.com.example.demo.designquestions.ATM.ATM;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextCashWithdrawProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        nextCashWithdrawProcessor=cashWithdrawProcessor;
    }


    public void withdraw(ATM atm, int remainingAmount) {

        if (nextCashWithdrawProcessor != null) {
            nextCashWithdrawProcessor.withdraw(atm, remainingAmount);
        }
    }


}
